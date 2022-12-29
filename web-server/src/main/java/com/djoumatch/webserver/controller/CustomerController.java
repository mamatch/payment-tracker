package com.djoumatch.webserver.controller;

import com.djoumatch.webserver.dto.CustomerResponse;
import com.djoumatch.webserver.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    /**
     * Get all the customer
     * @return A list of all the customers
     */
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
