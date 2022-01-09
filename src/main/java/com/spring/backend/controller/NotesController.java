package com.spring.backend.controller;

import com.spring.backend.entity.Notes;
import com.spring.backend.entity.Subjects;
//import com.spring.backend.entity.User;
import com.spring.backend.entity.AuthorProfile;
import com.spring.backend.repository.SubjectsRepository;
import com.spring.backend.repository.AuthorProfileRepository;
import com.spring.backend.service.NotesService;
//import com.spring.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NotesController {

    @Autowired
    private NotesService notesService;

    @Autowired
    private AuthorProfileRepository authorProfileRepository;

    @Autowired
    private SubjectsRepository subjectsRepository;

    //get all notes
    @GetMapping("/")
    public String notesPage(Model model) {
        List<Subjects> subjectsList = subjectsRepository.findAll();
        model.addAttribute("subjectsList",subjectsList);
        model.addAttribute("noteslist",notesService.getAllnotes());

        return "index";
    }
    
    @GetMapping("/allnotes")
    public String allNotesPage(Model model) {
        List<Subjects> subjectsList = subjectsRepository.findAll();
        model.addAttribute("subjectsList",subjectsList);
        model.addAttribute("noteslist",notesService.getAllnotes());

        return "allnotes";
    }

    //create a species page
    @GetMapping("/addnotes")
    public String shownotesCreatePage(Model model) {
        List<AuthorProfile> authorProfileList = authorProfileRepository.findAll();
        List<Subjects> subjectsList =  subjectsRepository.findAll();
        model.addAttribute("authorProfileList", authorProfileList );
        Notes notes = new Notes();
        model.addAttribute("notes",notes);
        model.addAttribute("subjectsList",subjectsList);
        return "addnotes";
    }

    @GetMapping("/notes/{id}")
    public String viewnotes(@PathVariable(value = "id") Long id, Model model) {
        Notes notes = notesService.getnotes(id);
        model.addAttribute("notesdtails",notes);
        List<Subjects> subjectsList =subjectsRepository.findAll();
        model.addAttribute("subjectsList",subjectsList);
        return "notes";
    }

    //save species to database
    @PostMapping("/createnotes")
    public String createsnotes(@ModelAttribute("notes") Notes notes) {
        notesService.createnotes(notes);
        return "redirect:/";
    }
}
