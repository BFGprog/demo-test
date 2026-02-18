package com.example.demo_test.mapper;

import com.example.demo_test.model.Comment;
import com.example.demo_test.model.dto.CommentDto;
import com.example.demo_test.reposotory.ThreadRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class CommentMapper {
    ThreadRepository threadRepository;

    public CommentMapper(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    public CommentDto toCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setText(comment.getText());
        commentDto.setCreate_date(comment.getCreate_date());
        return commentDto;
    }
    public Comment toComment(Long threadId, CommentDto commentDto){
        Comment comment = new Comment();
        comment.setText(commentDto.getText() + "qwerty");
        comment.setMessageThread(threadRepository.findById(threadId).orElseThrow(() -> new RuntimeException("not found")));
        return comment;
    }
}
