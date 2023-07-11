package com.example.BookCatalogueApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book newBook) {
        books.add(newBook);
    }

    @PutMapping("/books/{id}")
    public void editBook(@PathVariable int id, @RequestBody Book updatedBook) {
        books.removeIf(book -> book.getId() == id);
        books.add(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
    }

}
