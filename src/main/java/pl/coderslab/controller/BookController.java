package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.BookService;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@Controller  // zmienic na RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    @ResponseBody // usunac
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    @ResponseBody
    public
    List<Book> getList() {
        return bookService.getBooks();
    }
    @PostMapping("")
    @ResponseBody
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }
    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }


}
