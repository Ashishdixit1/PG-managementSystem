package com.org.service;

import com.org.model.PgDTO;

public interface PgService {
    PgDTO createPgDTO(PgDTO pg);

    PgDTO updatePgDTO(PgDTO pg, Integer id);

    PgDTO getPgDTO(Integer id);

    PgDTO deletePgDTO(Integer id);

}
