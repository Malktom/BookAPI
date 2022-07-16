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

    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    @ResponseBody // usunac
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("books")
    @ResponseBody // ususnac
    public List<Book> getBooksList () {

        return mockBookService.getList();
    }

    @GetMapping("addBook")
    public String hello() {
        return "/form";
    }
    @PostMapping("addBook")
    @ResponseBody
    public String createNewBook(@RequestParam(name="id") Long id ,
                                @RequestParam(name ="isbn") String isbn,
                                @RequestParam(name ="title") String title,
                                @RequestParam(name ="author") String author,
                                @RequestParam(name ="publisher") String publisher,
                                @RequestParam(name ="type") String type) {
        mockBookService.createNewBook(new Book(id,isbn,title,author,publisher,type));
        return "book added";

    }

    @GetMapping("books/{id}")
    @ResponseBody
        public Book showBook(@PathVariable int id) {

        return mockBookService.showBook(id);
    }
    @DeleteMapping("books/{id}")
    @ResponseBody
    public Book removeBook(@PathVariable int id) {

        return mockBookService.removeBook(id);
    }
}
