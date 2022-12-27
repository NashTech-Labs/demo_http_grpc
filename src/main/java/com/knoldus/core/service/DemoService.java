package com.knoldus.core.service;

import com.knoldus.spring.grpc.core.model.DemoRequest;
import com.knoldus.spring.grpc.core.model.DemoResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoService {

    public DemoResponse demo(DemoRequest request) throws ParseException {

        String demoDate = request.getDays() + "/" + request.getMonths()
            + "/" + request.getYears();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(demoDate);
        log.info("Received Demo time:- {} and message:- {}", date,
            request.getMessage());

        return DemoResponse.newBuilder()
            .setTime(String.valueOf(date))
            .setMessage(request.getMessage())
            .build();
    }
}
