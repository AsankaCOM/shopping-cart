package com.cart.controller;

import com.cart.dto.BookDTO;
import com.cart.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    //TODO Asanka, add Spring Security to limit access to this method
    //TODO Asanka, add status code to RS


    BookService bookService;

    public ShoppingCartController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookDTO> listBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/")
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }
}
