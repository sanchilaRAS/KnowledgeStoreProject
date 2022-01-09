package com.spring.backend.controller;

import com.spring.backend.entity.Author;
import com.spring.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //get all users
    @GetMapping("/authors")
    public String authorPage(Model model) {
        model.addAttribute("authorlist",authorService.getALlAuthor());
        return "viewauthors";
    }

    @GetMapping("/addauthor")
    public String showAuthorRegForm(Model model) {
        Author author= new Author();
        model.addAttribute("author",author);
        return "addauthor";
    }

    //register a user
    @PostMapping("/registerauthor")
    public String registerAuthor(@ModelAttribute("author") Author author) {
        authorService.createAuthor(author);
        return "redirect:/authors";
    }


}
