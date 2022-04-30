package com.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        final Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .addService(new CountServiceImpl())
                .build();

        server.start();
        System.out.println("Server has started");
        server.awaitTermination();
    }
}
