package com.djoumatch.webserver.controller;

import com.djoumatch.webserver.dto.CustomerRequest;
import com.djoumatch.webserver.dto.CustomerResponse;
import com.djoumatch.webserver.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Add a new customer
     * @param customerRequest the json object payload of teh request
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.addCustomer(customerRequest);
    }
}
