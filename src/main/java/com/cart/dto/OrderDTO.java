package com.cart.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
  private Long id;
  CustomerDTO customer;
  List<BookDTO> items;
}
