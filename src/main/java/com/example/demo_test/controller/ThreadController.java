package com.example.demo_test.controller;

import com.example.demo_test.model.dto.SentThreadDto;
import com.example.demo_test.model.dto.SentThreadDtoAll;
import com.example.demo_test.service.ThreadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/thread/")
public class ThreadController {
    ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping
    public List<SentThreadDtoAll> getAllThread() {
        return threadService.getAllThread();
    }
    @GetMapping("{id}")
    public SentThreadDto getThread(@PathVariable Long id) {
        return threadService.getThreadById(id);
    }

}
