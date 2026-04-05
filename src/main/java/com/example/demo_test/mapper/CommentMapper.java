package com.example.demo_test.mapper;

import com.example.demo_test.exception.ObjectNotFoundException404;
import com.example.demo_test.model.Comment;
import com.example.demo_test.model.dto.AddComment;
import com.example.demo_test.model.dto.CommentDto;
import com.example.demo_test.reposotory.ThreadRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommentMapper {
    ThreadRepository threadRepository;

    public CommentMapper(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }
    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public CommentDto toCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setCreate_date(comment.getCreate_date().format(formatter));
        return commentDto;
    }
    public Comment toComment(Long threadId, AddComment commentDto){
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setCreate_date(LocalDateTime.now());
        comment.setMessageThread(threadRepository.findById(threadId).orElseThrow(() -> new ObjectNotFoundException404("Thread " + threadId + " not found")));
        return comment;
    }
}
