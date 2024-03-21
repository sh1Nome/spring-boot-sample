package com.example.sample.service;

import java.util.Optional;

import org.springframework.ui.Model;

import com.example.sample.entity.Hello;

public interface HelloService {

    public Optional<Hello> findById(Integer id);

    public void modelAddAttribute(Integer id, Model model);

    public String getDispatch(Integer id);

}
