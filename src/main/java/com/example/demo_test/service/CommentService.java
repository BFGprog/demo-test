package com.example.demo_test.service;

import com.example.demo_test.mapper.CommentMapper;
import com.example.demo_test.model.Comment;
import com.example.demo_test.model.dto.AddComment;
import com.example.demo_test.model.dto.CommentDto;
import com.example.demo_test.reposotory.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    CommentRepository commentRepository;
    CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<CommentDto> getCommentsForThread(Long threadId) {
        List<Comment> comments = commentRepository.findByMessageThreadId(threadId);
        List<CommentDto> commentDto = comments.stream()
                .map(commentMapper::toCommentDto)
                .toList();
        return commentDto;
    }

    public CommentDto addComment(Long treadId, AddComment commentDto) {
        Comment comment = commentMapper.toComment(treadId, commentDto);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toCommentDto(savedComment);
    }
}
