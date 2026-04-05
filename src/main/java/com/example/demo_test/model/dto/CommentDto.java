package com.example.demo_test.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long id;
    private String text;
    private String create_date;
}
