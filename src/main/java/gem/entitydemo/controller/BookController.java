package gem.entitydemo.controller;

import gem.entitydemo.model.Book;
import gem.entitydemo.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
public class BookController
{
    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/books")
    public String getBook(Model model)
    {
        model.addAttribute("books" , bookRepository.findAll());
        return "books/book_list";
    }

/*
    @GetMapping("/books")
    public ArrayList<String> getBook(Model model)
    {
        ArrayList<String> bookArrayList= new ArrayList<>();
        model.addAttribute("books" , bookRepository.findAll());
        Iterator<Book> iterator = bookRepository.findAll().iterator();

        while (iterator.hasNext()) {
            Book element = iterator.next();
            bookArrayList.add(element.getBookTitle());
        }
        return bookArrayList;
    }
*/
}
