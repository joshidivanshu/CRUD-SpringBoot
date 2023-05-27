package com.javatdivanshu.controller;

import com.javatdivanshu.model.Books;
import com.javatdivanshu.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    private Books getBookById(@PathVariable("bookId") int bookId) {
        return booksService.getBooksById(bookId);
    }

    @DeleteMapping("/book/{bookId}")
    private void deleteBookById(@PathVariable("bookId") int bookId) {
        booksService.delete(bookId);
    }

    @PostMapping("/books")
    private int saveBook(@RequestBody Books book) {
        booksService.saveOrUpdate(book);
        return book.getBookId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }

}
