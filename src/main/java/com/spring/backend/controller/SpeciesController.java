package com.spring.backend.controller;

import com.spring.backend.entity.Species;
import com.spring.backend.entity.Tag;
//import com.spring.backend.entity.User;
import com.spring.backend.entity.UserProfile;
import com.spring.backend.repository.TagRepository;
import com.spring.backend.repository.UserProfileRepository;
import com.spring.backend.service.SpeciesService;
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
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private TagRepository tagRepository;

    //get all speciess
    @GetMapping("/")
    public String speciesPage(Model model) {
        List<Tag> tagList = tagRepository.findAll();
        model.addAttribute("tagList",tagList);
        model.addAttribute("specieslist",speciesService.getAllspeciess());

        return "index";
    }

    //create a species page
    @GetMapping("/addspecies")
    public String showspeciesCreatePage(Model model) {
        List<UserProfile> userProfileList = userProfileRepository.findAll();
        List<Tag> tagList =  tagRepository.findAll();
        model.addAttribute("userProfileList", userProfileList );
        Species species = new Species();
        model.addAttribute("species",species);
        model.addAttribute("tagList",tagList);
        return "addspecies";
    }

    @GetMapping("/species/{id}")
    public String viewspecies(@PathVariable(value = "id") Long id, Model model) {
        Species species = speciesService.getspecies(id);
        model.addAttribute("speciesdetails",species);
        List<Tag> tagList = tagRepository.findAll();
        model.addAttribute("tagList",tagList);
        return "species";
    }

    //save species to database
    @PostMapping("/createspecies")
    public String createspecies(@ModelAttribute("species") Species species) {
        speciesService.createspecies(species);
        return "redirect:/";
    }
}
