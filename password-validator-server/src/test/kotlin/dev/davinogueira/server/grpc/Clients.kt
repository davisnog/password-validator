package dev.davinogueira.server.grpc

import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import io.micronaut.grpc.server.GrpcServerChannel

@Factory
class Clients {
    @Bean
    fun blockingStub(@GrpcChannel(GrpcServerChannel.NAME) channel: ManagedChannel)
        : PasswordValidatorGrpc.PasswordValidatorBlockingStub {
        return PasswordValidatorGrpc.newBlockingStub(channel)
    }
}