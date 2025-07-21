package com.cart.service;

import com.cart.dto.BookDTO;
import com.cart.model.Book;
import com.cart.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {

        List<BookDTO> books = new ArrayList<>();

        bookRepository.findAll().forEach(book -> books.add(BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publicationYear(book.getPublicationYear())
                .price(book.getPrice())
                .build()));

        return books;
    }

    public void addBook(BookDTO bookDTO) {
        //TODO Asanka
        //  - validations
        //  - Error handling
        Book book = new Book(bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.getPublicationYear(),
                bookDTO.getPrice());
        bookRepository.save(book);
    }
}
