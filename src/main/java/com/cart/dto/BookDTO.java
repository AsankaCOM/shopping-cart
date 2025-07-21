package com.cart.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private Double price;
}
