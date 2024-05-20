package com.example.controller;

import com.example.dto.ContactDTO;
import com.example.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/general")
public class GeneralPageController {
    ContactService contactService;
    @Autowired
    public GeneralPageController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/header")
    private void getheaderlist(){

    }


    @GetMapping("/footer")
    private void getFooter(){

    }
}
