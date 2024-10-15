package com.example.springboot.thymeleafdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Student {

    String firstName;
    String lastName;
    String country;
    String favoriteLanguage;
    String favoriteSystems;
}
