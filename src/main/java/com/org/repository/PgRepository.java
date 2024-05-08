package com.org.repository;

import com.org.entity.PgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgRepository extends JpaRepository<PgEntity,Integer> {
}
