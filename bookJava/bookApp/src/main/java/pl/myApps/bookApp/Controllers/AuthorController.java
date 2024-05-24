package pl.myApps.bookApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.myApps.bookApp.Models.Author;
import pl.myApps.bookApp.Repositories.AuthorRepository;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping()
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorsById(@PathVariable("id") int id) {
        return authorRepository.getAuthorById(id);
    }

    @PostMapping()
    public int addAuthors(@RequestBody List<Author> authors) {
        return authorRepository.addAuthors(authors);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable("id") int id, @RequestBody Author author) {
        return authorRepository.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public int deleteAuthor(@PathVariable("id") int id) {
        return authorRepository.deleteAuthor(id);
    }
}