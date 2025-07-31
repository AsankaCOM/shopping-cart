package com.cart.service;

import com.cart.dto.BookDTO;
import com.cart.exception.BookNotFoundException;
import com.cart.exception.ErrorCode;
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

    public BookDTO getBookById(Long id) {
        //TODO Asanka, Add mapstruct
        return bookRepository.findById(id)
                .map(book -> BookDTO.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .isbn(book.getIsbn())
                        .publicationYear(book.getPublicationYear())
                        .price(book.getPrice())
                        .build())
                .orElseThrow(() -> new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND));
    }

    public void deleteBook(Long id) {
        if (getBookById(id) != null) {
            bookRepository.deleteById(id);
        }
    }

    public BookDTO addBook(Book book) {
        //TODO Asanka
        //  - validations
        //  - Error handling

        book = bookRepository.save(book);

        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publicationYear(book.getPublicationYear())
                .price(book.getPrice())
                .build();
    }
}
