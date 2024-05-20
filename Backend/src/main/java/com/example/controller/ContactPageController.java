package com.example.controller;

import com.example.dto.ContactDTO;
import com.example.dto.ContactFormDTO;
import com.example.service.ContactFormService;
import com.example.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactpage")
public class ContactPageController {

    ContactService contactService;
    ContactFormService contactFormService;

    @Autowired
    public ContactPageController(ContactFormService contactFormService, ContactService contactService) {
        this.contactFormService = contactFormService;
        this.contactService = contactService;
    }

    @GetMapping("/get")
    private ContactDTO getContactById(int contact_id){
        return contactService.GetByIdContact(contact_id);
    }

    @PostMapping("/post")
    private void createContactDetails(@RequestBody ContactDTO contactDTO) {
        contactService.CreateContact(contactDTO);
    }

    @PostMapping("/postform")
    private String sendContactForm(@RequestBody ContactFormDTO contactFormDTO) {
        contactFormService.SendContactForm(contactFormDTO);
        return "send it";
    }

    @GetMapping("/getform") //örnek için yazıldı silinecek.
    private List<ContactFormDTO> getform() {
        return contactFormService.GetContactForm();
    }
}
