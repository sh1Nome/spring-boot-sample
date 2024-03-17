package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sample.form.IndexForm;

@Controller
public class SampleController {
    @ModelAttribute
    public IndexForm setUpForm() {
        return new IndexForm();
    }

    @RequestMapping(value="index", method=RequestMethod.GET)
    public String dispatchIndex(Model model) {
        return "index";
    }

    @RequestMapping(value="hello", method=RequestMethod.POST)
    public String dispatchHello(@Validated IndexForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "hello";
    }
    
}
