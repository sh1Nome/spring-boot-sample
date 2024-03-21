package com.example.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.sample.entity.Hello;
import com.example.sample.repository.HelloCrudRepository;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloCrudRepository repository;

    String dispatch = null;

    @Override
    public Optional<Hello> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void modelAddAttribute(Integer id, Model model) {
        Optional<Hello> entitys = this.findById(id);
        entitys.ifPresent((entity) -> {
            model.addAttribute("hello", entity.getWord());
        });
    }

    @Override
    public String getDispatch(Integer id) {
        Optional<Hello> entitys = this.findById(id);
        entitys.ifPresentOrElse((entity) -> {
            dispatch = "hello";
        }, () -> {
            dispatch = "err";
        });
        return dispatch;
    }

}
