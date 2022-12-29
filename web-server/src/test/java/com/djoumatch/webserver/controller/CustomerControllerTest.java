package com.djoumatch.webserver.controller;

import com.djoumatch.webserver.dto.CustomerResponse;
import com.djoumatch.webserver.model.Customer;
import com.djoumatch.webserver.model.CustomerType;
import com.djoumatch.webserver.repository.CustomerRepository;
import com.djoumatch.webserver.repository.CustomerTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Container
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:13");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @DynamicPropertySource
    static void setDynamicProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
        dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.driver-class-name", postgreSQLContainer::getDriverClassName);
        dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    @Test
    void shouldGetTheRightNumberOfCustomers() throws Exception {
        CustomerType customerType = CustomerType.builder()
                .label("Frip")
                .build();
        Customer customer = Customer.builder()
                .name("dej")
                .location("dla")
                .customerType(customerType)
                .build();

        customerTypeRepository.save(customerType);
        customerRepository.save(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"name\":\"dej\",\"location\":\"dla\",\"customerType\":\"Frip\"}]"));
    }
}