package pl.myApps.bookApp.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.myApps.bookApp.Models.Book;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Book> getAllBooks() {
        String sql = "SELECT b.id, b.title, CONCAT(a.first_name, ' ', a.last_name) as author, c.name as category " +
                "FROM category c JOIN book b ON c.id = b.category JOIN author a ON b.author = a.id";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
    }

    public Book getBookById(int id) {
        String sql = "SELECT b.id, b.title, CONCAT(a.first_name, ' ', a.last_name) as author, c.name as category " +
                "FROM category c JOIN book b ON c.id = b.category JOIN author a ON b.author = a.id" +
        " WHERE b.id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Book.class), id);
    }

    public int addBooks(List <Book> books) {
        String sql = "INSERT INTO book (title, author, category) VALUES (?, ?, ?)";
        books.forEach(book -> jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getCategory()));
        return 1;
    }
}