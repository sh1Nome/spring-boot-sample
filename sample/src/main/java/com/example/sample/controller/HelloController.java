package com.example.sample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sample.entity.Hello;
import com.example.sample.form.IndexForm;
import com.example.sample.repository.HelloCrudRepository;

@Controller
public class HelloController {

    @Autowired
    HelloCrudRepository repository;

    @ModelAttribute
    public IndexForm setUpForm() {
        return new IndexForm();
    }

    @RequestMapping(value="hello", method=RequestMethod.POST)
    public String dispatchHello(@Validated IndexForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        Optional<Hello> word = repository.findById(1);
        if(word.isPresent()) {
            String hello = word.get().getWord();
            model.addAttribute("hello", hello);
            return "hello";
        }

        return "err";
    }
   
}
