package dev.davinogueira.server.grpc

import dev.davinogueira.server.validators.ValidatorService
import javax.inject.Singleton

@Singleton
class PasswordValidatorEndpoint(private val validatorService: ValidatorService)
    : PasswordValidatorGrpcKt.PasswordValidatorCoroutineImplBase() {

    override suspend fun validate(request: PasswordValidatorRequest): PasswordValidatorReply {
        val valid = validatorService.isValid(request.value)
        return PasswordValidatorReply.newBuilder().setValid(valid).build()
    }
}
