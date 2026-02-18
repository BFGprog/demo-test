package com.example.demo_test.service;

import com.example.demo_test.mapper.ThreadMapper;
import com.example.demo_test.model.MessageThread;
import com.example.demo_test.model.dto.SentThreadDto;
import com.example.demo_test.model.dto.SentThreadDtoAll;
import com.example.demo_test.model.dto.ThreadDto;
import com.example.demo_test.reposotory.ThreadRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadService {

    ThreadRepository threadRepository;
    ThreadMapper threadMapper;

    public ThreadService(ThreadRepository threadRepository, ThreadMapper threadMapper) {
        this.threadRepository = threadRepository;
        this.threadMapper = threadMapper;
    }

    public List<SentThreadDtoAll> getAllThread() {
//        log.info("Получение всех объявлений");
        List<MessageThread> threads = threadRepository.findAll();
        return threads.stream()
                .map(threadMapper::mapToSentThreadDtoAll)
                .toList();
    }

    public void addThread(ThreadDto threadDto)  {
//        log.info("Добавление нового объявления");
        MessageThread newMessageThread = threadMapper.dtoToThread(threadDto);
        threadRepository.save(newMessageThread);
    }

    public SentThreadDto getThreadById(Long id) {
//        log.info("Получение объявления с ID: {}", id);
        MessageThread messageThread = threadRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("не найдено"));
        return threadMapper.mapToSentThreadDto(messageThread);
    }

}
