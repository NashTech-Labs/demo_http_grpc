package com.knoldus.core.controller;

import com.knoldus.spring.grpc.core.model.CoreServiceGrpc;
import com.knoldus.spring.grpc.core.model.DemoRequest;
import com.knoldus.spring.grpc.core.model.DemoResponse;
import com.knoldus.core.service.DemoService;
import io.grpc.stub.StreamObserver;
import java.text.ParseException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GRpcService
public class DemoGrpcController extends CoreServiceGrpc.CoreServiceImplBase {
    @Autowired
    private DemoService demoService;

    @Override
    public void demo(DemoRequest request,
                      StreamObserver<DemoResponse> responseObserver) {
        try {
            responseObserver.onNext(demoService.demo(request));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        responseObserver.onCompleted();
    }
}
