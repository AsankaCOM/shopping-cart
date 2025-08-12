package com.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  private String author;

  private String isbn;

  private Integer publicationYear;

  private Double price;

  private String bookUrl;

  public Book(String title,
      String author,
      String isbn,
      Integer publicationYear,
      Double price,
      String bookUrl) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publicationYear = publicationYear;
    this.price = price;
    this.bookUrl = bookUrl;
  }
}
