package com.djoumatch.webserver.dto;

import com.djoumatch.webserver.model.CustomerType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
public class CustomerResponse {
    private String name;
    private String location;
    private String customerType;
}
