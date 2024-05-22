package pl.myApps.bookApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.myApps.bookApp.Models.Book;
import pl.myApps.bookApp.Repositories.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookRepository.getBookById(id);
    }

    @PostMapping()
    public int addBooks(@RequestBody List<Book> books) {
        return bookRepository.addBooks(books);
    }
}
