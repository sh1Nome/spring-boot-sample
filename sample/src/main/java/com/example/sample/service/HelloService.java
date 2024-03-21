package com.example.sample.service;

import org.springframework.ui.Model;

public interface HelloService {

    public void modelAddAttribute(Integer id, Model model);

    public String getDispatch(Integer id);

}
