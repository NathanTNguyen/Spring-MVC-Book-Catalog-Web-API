package com.example.BookCatalogueApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final List<Book> books = new ArrayList<>();

    //get all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    //search books by book name
    @GetMapping("/books/search")
    public List<Book> searchBookName(@RequestParam String bookName) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(bookName.toLowerCase()))
                .collect(Collectors.toList());
    }

    //search books by author name
    @GetMapping("/books/search")
    public List<Book> searchAuthor(@RequestParam String authorName) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(authorName.toLowerCase()))
                .collect(Collectors.toList());
    }

    //add book feature
    @PostMapping("/books")
    public void addBook(@RequestBody Book newBook) {
        books.add(newBook);
    }

    //edit book information by ID identification
    @PutMapping("/books/{id}")
    public void editBook(@PathVariable int id, @RequestBody Book updatedBook) {
        books.removeIf(book -> book.getId() == id);
        books.add(updatedBook);
    }

    //delete book by id
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
    }

}
