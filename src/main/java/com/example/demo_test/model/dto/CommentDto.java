package com.example.demo_test.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private String text;
    private LocalDateTime create_date;
}
