package com.djoumatch.webserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {

    private String name;
    private String location;
    private String customerType;
}