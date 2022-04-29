import grpc

import greeting_service_pb2
import greeting_service_pb2_grpc


def run():
    with grpc.insecure_channel('localhost:8080') as channel:
        stub = greeting_service_pb2_grpc.GreetingServiceStub(channel)
        response = stub.greeting(greeting_service_pb2.HelloRequest(
            name='Ilya', hobbies=['music', 'skating']))

        print("Greeting from the server: " + response.greeting)


run()
