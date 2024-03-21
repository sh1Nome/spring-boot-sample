package com.example.sample.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.annotation.RequestScope;

import com.example.sample.entity.Hello;
import com.example.sample.repository.HelloCrudRepository;

@RequestScope
@Service
public class HelloServiceImpl implements HelloService {

    private Optional<Hello> entitys = null;

    @Autowired
    private HelloCrudRepository repository;

    String dispatch = null;

    public Optional<Hello> findById(Integer id) {
        if(Objects.isNull(entitys)) {
            entitys = repository.findById(id);
        }
        return entitys;
    }

    @Override
    public void modelAddAttribute(Integer id, Model model) {
        this.findById(id).ifPresent((entity) -> {
            model.addAttribute("hello", entity.getWord());
        });
    }

    @Override
    public String getDispatch(Integer id) {
        this.findById(id).ifPresentOrElse((entity) -> {
            dispatch = "hello";
        }, () -> {
            dispatch = "err";
        });
        return dispatch;
    }

}
