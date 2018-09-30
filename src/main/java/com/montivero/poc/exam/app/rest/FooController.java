package com.montivero.poc.exam.app.rest;

import com.montivero.poc.exam.app.api.MessageApi;
import com.montivero.poc.exam.domain.model.Message;
import com.montivero.poc.exam.domain.service.ProcessMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/foo")
public class FooController {

    private final ProcessMessageService messageService;

    @Autowired
    public FooController(ProcessMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/bar")
    public ResponseEntity<?> bar(@RequestBody MessageApi message)
    {
        return new ResponseEntity<Message>(messageService.processMessage(message.getMessage()), HttpStatus.OK);
    }
}
