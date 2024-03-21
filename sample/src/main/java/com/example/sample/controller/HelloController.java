package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sample.form.IndexForm;
import com.example.sample.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    HelloService service;

    @ModelAttribute
    public IndexForm setUpForm() {
        return new IndexForm();
    }

    @RequestMapping(value="hello", method=RequestMethod.POST)
    public String dispatchHello(@Validated IndexForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        service.modelAddAttribute(1, model);
        return service.getDispatch(1);
    }

}
