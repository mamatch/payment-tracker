package com.djoumatch.webserver.service;

import com.djoumatch.webserver.dto.CustomerRequest;
import com.djoumatch.webserver.dto.CustomerResponse;
import com.djoumatch.webserver.model.Customer;
import com.djoumatch.webserver.model.CustomerType;
import com.djoumatch.webserver.repository.CustomerRepository;
import com.djoumatch.webserver.repository.CustomerTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerTypeRepository customerTypeRepository;

    /**
     * Get all the customer
     * @return A list of all the customers
     */
    @Transactional(readOnly = true)
    public List<CustomerResponse> getAllCustomers(){
        return customerRepository.findAll().stream().map(this::modelToDto).toList();
    }


    /**
     * Add a new customer
     * @param customerRequest the json object payload of teh request
     */
    @Transactional
    public void addCustomer(CustomerRequest customerRequest){
        // Check if the type exists
        CustomerType customerType = customerTypeRepository.findByLabel(customerRequest.getCustomerType())
                .orElseThrow(() -> new RuntimeException(String.format("Dint find the type: %s", customerRequest.getCustomerType())));
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .location(customerRequest.getLocation())
                .customerType(customerType)
                .build();

        customerRepository.save(customer);
    }



    private CustomerResponse modelToDto(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .location(customer.getLocation())
                .customerType(customer.getCustomerType().getLabel())
                .build();
    }
}
