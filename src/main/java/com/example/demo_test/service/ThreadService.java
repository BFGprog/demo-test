package com.example.demo_test.service;

import com.example.demo_test.exception.ObjectNotFoundException404;
import com.example.demo_test.mapper.ThreadMapper;
import com.example.demo_test.model.MessageThread;
import com.example.demo_test.model.dto.AddThread;
import com.example.demo_test.model.dto.ThreadDto;
import com.example.demo_test.reposotory.ThreadRepository;
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

    public List<ThreadDto> getAllThread() {
        List<MessageThread> threads = threadRepository.findAll();
        return threads.stream()
                .map(threadMapper::ThreadToThreadDto)
                .toList();
    }

    public ThreadDto addThread(AddThread addThread)  {
        MessageThread newMessageThread = threadMapper.addThreadToThread(addThread);
        return threadMapper.ThreadToThreadDto(threadRepository.save(newMessageThread));
    }

    public ThreadDto getThreadById(Long id) {
        MessageThread messageThread = threadRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException404("Thread " + id + " not found"));
        return threadMapper.ThreadToThreadDto(messageThread);
    }

}
