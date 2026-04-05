package com.example.demo_test.controller;

import com.example.demo_test.model.Comment;
import com.example.demo_test.model.dto.*;
import com.example.demo_test.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
//@RequestMapping("/thread")
@RequestMapping("/")
@Slf4j
public class ThreadController {
    ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping
    public List<ThreadDto> getAllThread() {
        return threadService.getAllThread();
    }
    @GetMapping("{id}")
    public ThreadDto getThread(@PathVariable Long id) {
        return threadService.getThreadById(id);
    }

    @PostMapping
    public ThreadDto addComment(@RequestBody AddThread addThread) {
        log.info( addThread.toString() );
        return threadService.addThread(addThread);
    }
}
