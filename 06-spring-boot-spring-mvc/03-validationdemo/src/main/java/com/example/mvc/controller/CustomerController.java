package com.example.mvc.controller;

import com.example.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String inputForm(Model theModel  ) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/showCustomer")
    public String showCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult ) {

        System.out.println("Bindin result : " + theBindingResult.toString());

        if(theBindingResult.hasErrors()) {
            return "customer-form";
        }else{
            System.out.println("last name : "+theCustomer.getLastName());
            return"customer-confirmation";
        }


    }
}
