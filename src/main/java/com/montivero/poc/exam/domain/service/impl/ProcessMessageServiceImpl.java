package com.montivero.poc.exam.domain.service.impl;

import com.montivero.poc.exam.domain.model.Message;
import com.montivero.poc.exam.domain.service.ProcessMessageService;
import org.springframework.stereotype.Service;

@Service
public class ProcessMessageServiceImpl implements ProcessMessageService {

    @Override
    public Message processMessage(String message) {
        return new Message(message);
    }
}
