package com.example.demo_test.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SentThreadDtoAll {

    private Long id; //нужен?
    private String thread;
    private String text;
    private String create_date;
}
