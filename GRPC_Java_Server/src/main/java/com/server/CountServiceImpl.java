package com.server;

import com.google.protobuf.Empty;
import com.server.grpc.CountServiceGrpc.CountServiceImplBase;
import com.server.grpc.CountServiceOuterClass.CountResponse;
import io.grpc.stub.StreamObserver;

import java.util.stream.IntStream;

public class CountServiceImpl extends CountServiceImplBase {
    @Override
    public void countToHundred(Empty request,
                               StreamObserver<CountResponse> responseObserver) {
        IntStream.range(1, 100).forEach(num -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            final CountResponse response = CountResponse.newBuilder()
                    .setCountValue(num)
                    .build();

            responseObserver.onNext(response);
        });
        responseObserver.onCompleted();
    }
}
