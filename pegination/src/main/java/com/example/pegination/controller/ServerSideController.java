package com.example.pegination.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.pegination.entity.Hoge;
import com.example.pegination.form.ServerSideForm;
import com.example.pegination.service.ServerSideService;

@Controller
public class ServerSideController {

    private final ServerSideService serverSideService;

    public ServerSideController(ServerSideService serverSideService) {
        this.serverSideService = serverSideService;
    }

    @ModelAttribute
    public ServerSideForm setUpForm() {

        List<Hoge> allRecordList = serverSideService.findAllList();
        return new ServerSideForm(0, allRecordList.size());

    }

    @GetMapping(value = "server_side")
    public String showServerSide(ServerSideForm form, Model model) {

        List<Hoge> allRecordList = serverSideService.findAllList();

        List<Hoge> displayRecordList = serverSideService.narrowDownDisplayList(form, allRecordList);

        model.addAttribute("displayRecordList", displayRecordList);

        return "server_side";

    }

    @GetMapping(value = "server_side", params = "next")
    public String showServerSideNext(ServerSideForm form, Model model) {

        serverSideService.pageTurn(form, true);

        return showServerSide(form, model);

    }

    @GetMapping(value = "server_side", params = "prev")
    public String showServerSidePrev(ServerSideForm form, Model model) {

        serverSideService.pageTurn(form, false);

        return showServerSide(form, model);

    }

}
