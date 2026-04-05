package com.example.demo_test.service;

import com.example.demo_test.reposotory.CommentRepository;
import com.example.demo_test.reposotory.ThreadRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Service
public class DataControl {
    private ThreadRepository threadRepository;
    private CommentRepository commentRepository;

    public DataControl(ThreadRepository threadRepository, CommentRepository commentRepository) {
        this.threadRepository = threadRepository;
        this.commentRepository = commentRepository;
    }

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
    public void cleanOldData() {
        LocalDateTime time = LocalDateTime.now().minusMinutes(5);
        commentRepository.deleteCommentsByOldThreads(time);
        threadRepository.deleteOldThreads(time);

    }

}

