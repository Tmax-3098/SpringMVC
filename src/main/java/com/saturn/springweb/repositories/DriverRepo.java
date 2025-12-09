package com.saturn.springweb.repositories;

import com.saturn.springweb.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<DriverEntity, Long> {
}
