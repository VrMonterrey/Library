package pl.myApps.bookApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.myApps.bookApp.Models.Category;
import pl.myApps.bookApp.Repositories.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
    public List<Category> getAllAuthors() {
        return categoryRepository.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getAuthorsById(@PathVariable("id") int id) {
        return categoryRepository.getCategoryById(id);
    }

    @PostMapping()
    public int addAuthors(@RequestBody List<Category> categories) {
        return categoryRepository.addCategories(categories);
    }
}