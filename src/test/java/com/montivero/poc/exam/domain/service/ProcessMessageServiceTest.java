package com.montivero.poc.exam.domain.service;

import com.montivero.poc.exam.domain.model.Message;
import com.montivero.poc.exam.domain.service.impl.ProcessMessageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ProcessMessageServiceTest {

    private ProcessMessageServiceImpl messageService;

    @Before
    public void setUp() {
        messageService = new ProcessMessageServiceImpl();
    }

    @Test
    public void processMessage() {
        String messageTest = "TEST";
        Message message = messageService.processMessage(messageTest);

        assertNotNull(message);
        assertEquals(message.getMessage(), messageTest);
    }
}
