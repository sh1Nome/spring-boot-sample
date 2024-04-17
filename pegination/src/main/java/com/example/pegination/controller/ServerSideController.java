package com.example.pegination.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.pegination.entity.Hoge;
import com.example.pegination.form.ServerSideForm;
import com.example.pegination.properties.PeginationProperties;
import com.example.pegination.repository.HogeRepository;

@Controller
public class ServerSideController {

    @Autowired
    HogeRepository repository;

    @Autowired
    PeginationProperties peginationProperties;

    @ModelAttribute
    public ServerSideForm setUpForm() {
        return new ServerSideForm(0);
    }

    @GetMapping(value = "server_side")
    public String showServerSide(ServerSideForm form, Model model) {

        Iterable<Hoge> allRecordIterable = repository.findAll();
        List<Hoge> allRecordList = new ArrayList<>();
        allRecordIterable.forEach((record) -> {
            allRecordList.add(record);
        });

        List<Hoge> displayRecordList = new ArrayList<>();
        int startIndex = form.getCurrentIndex();
        int endIndex = 0;
        if (startIndex + peginationProperties.getSize() < allRecordList.size()) {
            endIndex = startIndex + peginationProperties.getSize();
        } else {
            endIndex = allRecordList.size();
        }
        for (int i = startIndex; i < endIndex; i++) {
            displayRecordList.add(allRecordList.get(i));
        }

        model.addAttribute("displayRecordList", displayRecordList);
        return "server_side";

    }

    @GetMapping(value = "server_side", params = "prev")
    public String showServerSidePrev(ServerSideForm form, Model model) {

        if (0 <= form.getCurrentIndex() - peginationProperties.getSize()) {
            form.setCurrentIndex(form.getCurrentIndex() - peginationProperties.getSize());
        }

        return showServerSide(form, model);

    }

    @GetMapping(value = "server_side", params = "next")
    public String showServerSideNext(ServerSideForm form, Model model) {

        Iterable<Hoge> allRecordIterable = repository.findAll();
        List<Hoge> allRecordList = new ArrayList<>();
        allRecordIterable.forEach((record) -> {
            allRecordList.add(record);
        });

        if (form.getCurrentIndex() + peginationProperties.getSize() <= allRecordList.size()) {
            form.setCurrentIndex(form.getCurrentIndex() + peginationProperties.getSize());
        }
        
        return showServerSide(form, model);

    }

}
