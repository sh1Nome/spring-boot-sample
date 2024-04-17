package com.example.pegination.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("hoge")
public class Hoge {

    @Id
    @Column("id")
    private Integer id;

    @Column("fuga")
    private String fuga;

}
