package com.djoumatch.webserver.repository;

import com.djoumatch.webserver.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
