package com.example.demo_test.mapper;


import com.example.demo_test.model.MessageThread;
import com.example.demo_test.model.dto.AddThread;
import com.example.demo_test.model.dto.ThreadDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ThreadMapper {
    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public ThreadDto ThreadToThreadDto(MessageThread messageThread) {
        ThreadDto threadDto = new ThreadDto();
        threadDto.setThread(messageThread.getThread());
        threadDto.setId(messageThread.getId());
        threadDto.setText(messageThread.getText());
        threadDto.setCreate_date(messageThread.getCreate_date().format(formatter));
        return threadDto;
    }

    public MessageThread addThreadToThread(AddThread addThread) {
        MessageThread newThread = new MessageThread();
        newThread.setThread(addThread.getThread());
        newThread.setText(addThread.getText());
        newThread.setCreate_date(LocalDateTime.now());
        return newThread;
    }

}
