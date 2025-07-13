package com.example.BookManagementSystemUsingSpringJDBC.Service;

import java.util.List;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import com.example.BookManagementSystemUsingSpringJDBC.Entity.Book;
import com.example.BookManagementSystemUsingSpringJDBC.Repository.BookRepository;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        logger.info("Fetching all books");
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        logger.info("Fetching book with id {}", id);
        return repository.findById(id);
    }

    public void saveBook(Book book) {
        logger.info("Saving new book: {}", book.getTitle());
        repository.save(book);
    }

    public void updateBook(Book book) {
        logger.info("Updating book with id {}", book.getId());
        repository.update(book);
    }

    public void deleteBook(Long id) {
        logger.info("Deleting book with id {}", id);
        repository.deleteById(id);
    }
}
