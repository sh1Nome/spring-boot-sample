package com.example.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.sample.entity.Hello;
import com.example.sample.repository.HelloCrudRepository;

import lombok.Data;

@Data
@Service
public class HelloServiceImpl implements HelloService {

    Integer id = null;

    Model model = null;

    @Autowired
    HelloCrudRepository repository;

    public Optional<Hello> findById() {
        return repository.findById(this.id);
    }

    public void AddAttribute() {
        Optional<Hello> entitys = this.findById();
        entitys.ifPresent((e) -> {
            this.model.addAttribute("hello", entitys.get().getWord());
        });
    }
}
