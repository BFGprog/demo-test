package com.example.demo_test.mapper;


import com.example.demo_test.model.MessageThread;
import com.example.demo_test.model.dto.SentThreadDto;
import com.example.demo_test.model.dto.SentThreadDtoAll;
import com.example.demo_test.model.dto.ThreadDto;
import org.springframework.stereotype.Component;

@Component
public class ThreadMapper {

    public SentThreadDto mapToSentThreadDto(MessageThread messageThread) {
        SentThreadDto threadDto = new SentThreadDto();
        threadDto.setId(messageThread.getId());
        threadDto.setText(messageThread.getText());
        return threadDto;
    }

    public MessageThread dtoToThread(ThreadDto threadDto) {
        MessageThread newThread = new MessageThread();
        newThread.setText(threadDto.getText());
        return newThread;
    }
    public SentThreadDtoAll mapToSentThreadDtoAll(MessageThread messageThread) {
        SentThreadDtoAll threadDto = new SentThreadDtoAll();
        threadDto.setId(messageThread.getId());
        threadDto.setText(messageThread.getText());
        return threadDto;
    }


}
