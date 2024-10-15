package com.example.mvc.model;

import com.example.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 2 , message = "is required")
    // @NotBlank
    private String lastName;

    @Min(value=0,message = "must be greater than or equal to zero ")
    @Max(value = 10,message = "must be less than or equals to 10")
    @NotNull(message = "is required")
    private Integer freePasses;


    //@Pattern(regexp ="^[a-zA-Z0-9]{5}",message = "only 5 chars/digit")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;
}
