package com.cart.controller;

import com.cart.dto.BookDTO;
import com.cart.model.Book;
import com.cart.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

  BookService bookService;

  public ShoppingCartController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public ResponseEntity<List<BookDTO>> listBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.getBookById(id));
  }

  @PostMapping("/books")
  public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
    BookDTO book = bookService.addBook(new Book(bookDTO.getTitle(),
        bookDTO.getAuthor(),
        bookDTO.getIsbn(),
        bookDTO.getPublicationYear(),
        bookDTO.getPrice(),
        bookDTO.getBookUrl()));

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(book.getId())
        .toUri();

    return ResponseEntity.created(location)
        .body(book);
  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.ok().build();
  }
}
