package com.djoumatch.webserver.repository;

import com.djoumatch.webserver.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
    public Optional<CustomerType> findByLabel(String label);
}
