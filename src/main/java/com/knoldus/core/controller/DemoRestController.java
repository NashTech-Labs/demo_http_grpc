package com.knoldus.core.controller;

import com.knoldus.spring.grpc.core.model.DemoRequest;
import com.knoldus.core.service.DemoService;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class DemoRestController {
    @Autowired
    private DemoService demoService;

    @PostMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> demo(@RequestBody DemoRequest request)
        throws ParseException {
        return ResponseEntity.ok(demoService.demo(request));
    }
}
