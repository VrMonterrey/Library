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
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        return categoryRepository.getCategoryById(id);
    }

    @PostMapping()
    public int addCategories(@RequestBody List<Category> categories) {
        return categoryRepository.addCategories(categories);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        return categoryRepository.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public int deleteCategory(@PathVariable("id") int id) {
        return categoryRepository.deleteCategory(id);
    }
}