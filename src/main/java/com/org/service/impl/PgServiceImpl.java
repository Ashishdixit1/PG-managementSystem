package com.org.service.impl;

import com.org.entity.AddressEntity;
import com.org.entity.PgEntity;
import com.org.model.AddressDTO;
import com.org.model.PgDTO;
import com.org.repository.AddressRepository;
import com.org.repository.PgRepository;
import com.org.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PgServiceImpl implements PgService {

    @Autowired
    PgRepository pgRepository;


    @Override
    public PgDTO createPgDTO(PgDTO pg) {
        PgEntity pgEntity = new PgEntity();
        pgEntity.setName(pg.getName());
        pgEntity.setAddress(pg.getAddress());
        pgEntity.setRent(pg.getRent());
        pgEntity.setReview(pg.getReview());
        AddressDTO addressDTO = pg.getAddressDetails();
        if (addressDTO != null) {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setCity(addressDTO.getCity());
            addressEntity.setState(addressDTO.getState());
            addressEntity.setStreet(addressDTO.getStreet());
            addressEntity.setPostalCode(addressDTO.getPostalCode());
            pgEntity.setAddressDetails(addressEntity);
        }
        pgRepository.save(pgEntity);
        pg.setId(pgEntity.getId());
        pg.getAddressDetails().setId(pgEntity.getAddressDetails().getId());
        return pg;
    }

    @Override
    public PgDTO updatePgDTO(PgDTO pg, Integer id) {
        Optional<PgEntity> optionalPgEntity = pgRepository.findById(id);
        if (optionalPgEntity.isPresent()) {
            PgEntity pgEntity = optionalPgEntity.get();
            pgEntity.setName(pg.getName());
            pgEntity.setRent(pg.getRent());
            pgEntity.setReview(pg.getReview());
            AddressEntity addressEntity = pgEntity.getAddressDetails();
            AddressDTO addressDTO = pg.getAddressDetails();
            addressEntity.setPostalCode(addressDTO.getPostalCode());
            addressEntity.setState(addressDTO.getState());
            addressEntity.setStreet(addressDTO.getStreet());
            addressEntity.setCity(addressDTO.getCity());
            pgEntity.setAddressDetails(addressEntity);
            pgRepository.save(pgEntity);
            return pg;
        }
        return null;

    }

    @Override
    public PgDTO getPgDTO(Integer id) {
        Optional<PgEntity> optionalPgEntity = pgRepository.findById(id);
        if (optionalPgEntity.isPresent()) {
            PgEntity pgEntity = optionalPgEntity.get();
            PgDTO pgDTO = new PgDTO();
            pgDTO.setId(pgEntity.getId());
            pgDTO.setName(pgEntity.getName());
            pgDTO.setAddress(pgEntity.getAddress());
            pgDTO.setRent(pgEntity.getRent());
            pgDTO.setReview(pgEntity.getReview());
            if (optionalPgEntity.get().getAddressDetails() != null) {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setId(pgEntity.getAddressDetails().getId());
                addressDTO.setCity(pgEntity.getAddressDetails().getCity());
                addressDTO.setState(pgEntity.getAddressDetails().getState());
                addressDTO.setStreet(pgEntity.getAddressDetails().getStreet());
                addressDTO.setPostalCode(pgEntity.getAddressDetails().getPostalCode());
                pgDTO.setAddressDetails(addressDTO);
            }
            return pgDTO;
        }
        return null;
    }

    @Override
    public PgDTO deletePgDTO(Integer id) {
        pgRepository.deleteById(id);
        return null;
    }


}
