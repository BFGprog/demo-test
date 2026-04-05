package com.example.demo_test.model.dto;

import lombok.Data;


@Data
public class ThreadDto {

    private Long id;
    private String thread;
    private String text;
    private String create_date;
}
