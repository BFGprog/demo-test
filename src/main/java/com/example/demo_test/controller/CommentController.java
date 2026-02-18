package com.example.demo_test.controller;


import com.example.demo_test.model.dto.CommentDto;
import com.example.demo_test.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/thread")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/{threadId}/comments")
    public List<CommentDto> getComments(@PathVariable Long threadId) {
        return commentService.getCommentsForThread(threadId);
    }


}
