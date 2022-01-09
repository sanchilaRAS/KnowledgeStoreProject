package com.spring.backend.controller;

import com.spring.backend.service.AuthorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class AuthorProfileController {

    @Autowired
    private AuthorProfileService authorProfileService;


}
