package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactDTO {
    private String contact_address;
    private String contact_tel;
    private String contact_email;
}
