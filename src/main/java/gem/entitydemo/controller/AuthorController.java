package gem.entitydemo.controller;

import gem.entitydemo.model.Author;
import gem.entitydemo.repositories.AuthorRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthorController
{
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAuthor(Model model)
    {
        model.addAttribute("authors" , authorRepository.findAll());
        return "author";
    }
}
