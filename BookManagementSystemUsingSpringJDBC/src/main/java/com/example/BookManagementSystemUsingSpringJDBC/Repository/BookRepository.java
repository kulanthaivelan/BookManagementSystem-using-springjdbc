package com.example.BookManagementSystemUsingSpringJDBC.Repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.BookManagementSystemUsingSpringJDBC.Entity.Book;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> rowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublicationYear(rs.getInt("publication_year"));
        return book;
    };

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", rowMapper);
    }

    public Book findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?", rowMapper, id);
    }

    public void save(Book book) {
        jdbcTemplate.update(
            "INSERT INTO book (title, author, publication_year) VALUES (?, ?, ?)",
            book.getTitle(), book.getAuthor(), book.getPublicationYear()
        );
    }

    public void update(Book book) {
        jdbcTemplate.update(
            "UPDATE book SET title=?, author=?, publication_year=? WHERE id=?",
            book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getId()
        );
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
