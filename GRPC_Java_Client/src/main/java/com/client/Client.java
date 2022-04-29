package com.client;

import com.server.grpc.GreetingServiceGrpc;
import com.server.grpc.GreetingServiceGrpc.GreetingServiceBlockingStub;
import com.server.grpc.GreetingServiceOuterClass.HelloRequest;
import com.server.grpc.GreetingServiceOuterClass.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

    public static void main(String[] args) {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        final GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        final HelloRequest request = HelloRequest.newBuilder()
                .setName("Ilya")
                .build();

        final HelloResponse response = stub.greeting(request);
        System.out.println(response);

        channel.shutdownNow();
    }
}
