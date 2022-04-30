package com.client;

import com.google.protobuf.Empty;
import com.server.grpc.CountServiceGrpc;
import com.server.grpc.CountServiceGrpc.CountServiceBlockingStub;
import com.server.grpc.CountServiceOuterClass.CountResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class CountClient {

    public static void main(String[] args) {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        final CountServiceBlockingStub stub = CountServiceGrpc.newBlockingStub(channel);

        final Iterator<CountResponse> responseIterator = stub.countToHundred(Empty.newBuilder().build());
        while (responseIterator.hasNext()) {
            System.out.println(responseIterator.next());
        }

        channel.shutdownNow();
    }
}
