package com.example.demo_test.service;

import com.example.demo_test.model.Comment;
import com.example.demo_test.model.MessageThread;
import com.example.demo_test.reposotory.CommentRepository;
import com.example.demo_test.reposotory.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class DataInitializerService implements CommandLineRunner {

    private final ThreadRepository threadRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) {

        if (threadRepository.count() > 0) {
            return; // чтобы не создавать дубликаты при каждом запуске
        }

        for (int i = 1; i <= 3; i++) {

            MessageThread thread = new MessageThread();
            thread.setText("Thread " + i);
            thread.setCreate_date(LocalDateTime.now());

            threadRepository.save(thread);

            for (int j = 1; j <= 3; j++) {
                Comment comment = new Comment();
                comment.setText("Comment " + j + " for thread " + i);
                comment.setCreate_date(LocalDateTime.now());

                // важная часть — установка связи
                comment.setMessageThread(thread);

                commentRepository.save(comment);
            }
        }
    }
}
