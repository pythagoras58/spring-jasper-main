package com.example.springjasper.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class StudentModel {

    private long id;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
}
