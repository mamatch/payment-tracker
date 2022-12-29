package com.djoumatch.webserver.service;

import com.djoumatch.webserver.dto.CustomerResponse;
import com.djoumatch.webserver.model.Customer;
import com.djoumatch.webserver.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Get all the customer
     * @return A list of all the customers
     */
    public List<CustomerResponse> getAllCustomers(){
        return customerRepository.findAll().stream().map(this::modelToDto).toList();
    }



    private CustomerResponse modelToDto(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .location(customer.getLocation())
                .customerType(customer.getCustomerType().getLabel())
                .build();
    }
}
