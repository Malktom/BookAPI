package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@Controller  // zmienic na RestController
@RequestMapping("/books")
public class BookController {

    private MockBookService mockBookService;


    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    @ResponseBody // usunac
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    @ResponseBody // ususnac
    public List<Book> getBooksList () {

        return mockBookService.getList();
    }


    @PostMapping("")
    @ResponseBody
    public String createNewBook(@RequestBody Book book) {
        mockBookService.createNewBook(book);
        return "book added";
    }
    @GetMapping("/{id}")
    @ResponseBody
        public Book showBook(@PathVariable int id) {

        return mockBookService.showBook(id);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public Book removeBook(@PathVariable int id) {

        return mockBookService.removeBook(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        mockBookService.update(book);
    }


}
