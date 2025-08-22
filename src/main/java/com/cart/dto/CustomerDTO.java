package com.cart.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private String name;
    private String email;
}
