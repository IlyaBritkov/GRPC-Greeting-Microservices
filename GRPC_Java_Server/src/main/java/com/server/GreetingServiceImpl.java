package com.server;

import com.server.grpc.GreetingServiceGrpc.GreetingServiceImplBase;
import com.server.grpc.GreetingServiceOuterClass.HelloRequest;
import com.server.grpc.GreetingServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest request,
                         StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        final HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hello from server, user " + request.getName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
