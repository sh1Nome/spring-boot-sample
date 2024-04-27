package com.example.pegination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pegination.entity.Hoge;
import com.example.pegination.form.ServerSideForm;
import com.example.pegination.properties.PaginationProperties;
import com.example.pegination.repository.HogeRepository;

@Service
public class ServerSideServiceImpl implements ServerSideService {

    private final PaginationProperties peginationProperties;

    private final HogeRepository repository;

    public ServerSideServiceImpl(PaginationProperties peginationProperties, HogeRepository repository) {
        this.peginationProperties = peginationProperties;
        this.repository = repository;
    }

    @Override
    public List<Hoge> findAllList() {

        Iterable<Hoge> allRecordIterable = repository.findAll();
        List<Hoge> allRecordList = new ArrayList<>();
        allRecordIterable.forEach((record) -> {
            allRecordList.add(record);
        });

        return allRecordList;

    }

    @Override
    public List<Hoge> narrowDownDisplayList(ServerSideForm form, List<Hoge> allRecordList) {
        List<Hoge> displayRecordList = new ArrayList<>();
        int startIndex = form.getStartIndex();
        int endIndex = 0;
        if (startIndex + peginationProperties.getSize() < allRecordList.size()) {
            endIndex = startIndex + peginationProperties.getSize();
        } else {
            endIndex = allRecordList.size();
        }
        for (int i = startIndex; i < endIndex; i++) {
            displayRecordList.add(allRecordList.get(i));
        }
        return displayRecordList;
    }

    @Override
    public void pageTurn(ServerSideForm form, boolean next) {
        if (next) {
            if (form.getStartIndex() + peginationProperties.getSize() <= form.getEndIndex()) {
                form.setStartIndex(form.getStartIndex() + peginationProperties.getSize());
            }
        } else {
            if (0 <= form.getStartIndex() - peginationProperties.getSize()) {
                form.setStartIndex(form.getStartIndex() - peginationProperties.getSize());
            }
        }
    }



}
