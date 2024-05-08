package com.org.controller;

import com.org.entity.PgEntity;
import com.org.model.PgDTO;
import com.org.repository.PgRepository;
import com.org.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PgController {
    @Autowired
    PgService pgService;



    @PostMapping("/pg")
    public PgDTO createPg(@RequestBody PgDTO pg) {
        pgService.createPgDTO(pg);
        return pg;
    }

    @GetMapping("/pg/{id}")
    public PgDTO getByid(@PathVariable Integer id) {
        if (id == 0) {
         System.out.println("id can't be zero");
        }
        return pgService.getPgDTO(id);
    }

    @PutMapping("pg/{id}")
    public PgDTO updateByid(@PathVariable Integer id, @RequestBody PgDTO pg) {
        return pgService.updatePgDTO(pg, id);

    }

    @DeleteMapping("pg/{id}")
    public PgDTO deleteByid(@PathVariable Integer id) {
        pgService.deletePgDTO(id);
        return null;
    }


}
