package pl.myApps.bookApp.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.myApps.bookApp.Models.Category;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM category";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class), id);
    }

    public int addCategories(List<Category> categories) {
        String sql = "INSERT INTO category (name) VALUES (?)";
        categories.forEach(category -> jdbcTemplate.update(sql, category.getName()));
        return 1;
    }

    public int updateCategory(int id, Category category) {
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, category.getName(), id);
    }

    public int deleteCategory(int id) {
        String sql = "DELETE FROM category WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}