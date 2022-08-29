package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.BookService;
import pl.coderslab.model.Book;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }
    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result) { // dodane alby wyswietlic kominkat bledu

        if (result.hasErrors()) {
            return "addBook";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<Book> byId = bookService.get(id);
        model.addAttribute("book", byId);
        return "addBook";

    }

    @PostMapping("/edit/{id}")
    public String edit(Book book) {
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public String showById(@PathVariable Long id, Model model) {
        Optional<Book> byId = bookService.get(id);
        model.addAttribute("book", byId);
        return byId.toString();

    }

}
