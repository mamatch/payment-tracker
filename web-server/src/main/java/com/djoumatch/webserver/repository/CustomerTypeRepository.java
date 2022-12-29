package com.djoumatch.webserver.repository;

import com.djoumatch.webserver.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
