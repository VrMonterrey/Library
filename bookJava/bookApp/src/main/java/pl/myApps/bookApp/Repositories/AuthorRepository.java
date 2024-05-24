package pl.myApps.bookApp.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.myApps.bookApp.Models.Author;

import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Author> getAllAuthors() {
        String sql = "SELECT * FROM author";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Author.class));
    }

    public Author getAuthorById(int id) {
        String sql = "SELECT * FROM author WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Author.class), id);
    }

    public int addAuthors(List<Author> authors) {
        String sql = "INSERT INTO author (first_name, last_name) VALUES (?, ?)";
        authors.forEach(author -> jdbcTemplate.update(sql, author.getFirst_name(), author.getLast_name()));
        return 1;
    }

    public Author updateAuthor(int id, Author author) {
        String sql = "UPDATE author SET first_name = ?, last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, author.getFirst_name(), author.getLast_name(), id);
        return getAuthorById(id);
    }

    public int deleteAuthor(int id) {
        String sql = "DELETE FROM author WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}