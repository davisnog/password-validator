package dev.davinogueira.client.service

import dev.davinogueira.server.grpc.PasswordValidatorGrpc
import dev.davinogueira.server.grpc.PasswordValidatorRequest
import io.micronaut.context.annotation.Prototype

@Prototype
class PasswordValidatorService(val client: PasswordValidatorGrpc.PasswordValidatorBlockingStub) {

    fun isValid(password: String) : Boolean {
        val request = PasswordValidatorRequest.newBuilder().setValue(password).build()
        return client.validate(request).valid
    }
}