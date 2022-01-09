package com.spring.backend.controller;

import com.spring.backend.entity.Subjects;
import com.spring.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectsController {

    @Autowired
    private SubjectsService subjectsService;

    @GetMapping("/subjects")
    public String subjectsPage(Model model) {
        model.addAttribute("subjectslist", subjectsService.getAllSubjects());
        return "viewtag";
    }

    @GetMapping("/addsubjects")
    public String showRegForm(Model model) {
        Subjects subjects = new Subjects();
        model.addAttribute("subject", subjects);
        return "addsubjects";
    }

    @PostMapping("/createsubject")
    public String createSubjects(@ModelAttribute("subject") Subjects subjects) {
        subjectsService.createSubjects(subjects);
        return "redirect:/";
    }
}
