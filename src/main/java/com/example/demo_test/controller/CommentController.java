package com.example.demo_test.controller;


import com.example.demo_test.model.dto.AddComment;
import com.example.demo_test.model.dto.CommentDto;
import com.example.demo_test.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/thread")
@Slf4j
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/{threadId}/comments")
    public List<CommentDto> getComments(@PathVariable Long threadId) {
        return commentService.getCommentsForThread(threadId);
    }
    @PostMapping("/{threadId}/comments")
    public CommentDto addComment(@PathVariable Long threadId, @RequestBody AddComment comment) {
        log.info(threadId.toString() + " - " + comment.toString());
        return commentService.addComment(threadId, comment);
    }


}
