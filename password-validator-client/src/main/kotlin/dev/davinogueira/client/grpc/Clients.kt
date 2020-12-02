package dev.davinogueira.client.grpc

import dev.davinogueira.server.grpc.PasswordValidatorGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class Clients {

    @Singleton
    fun reactiveStub(@GrpcChannel("http://localhost:8081") channel : ManagedChannel):
            PasswordValidatorGrpc.PasswordValidatorBlockingStub {
        return PasswordValidatorGrpc.newBlockingStub(channel)
    }
}