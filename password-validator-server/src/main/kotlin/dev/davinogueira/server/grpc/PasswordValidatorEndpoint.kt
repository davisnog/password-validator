package dev.davinogueira.server.grpc

import dev.davinogueira.server.validators.ValidatorService
import javax.inject.Singleton

@Singleton
class PasswordValidatorEndpoint(val validadorService: ValidatorService) : PasswordValidatorGrpcKt.PasswordValidatorCoroutineImplBase() {

    override suspend fun validate(request: PasswordValidatorRequest): PasswordValidatorReply {
        val valid = validadorService.isValid(request.value)
        return PasswordValidatorReply.newBuilder().setValid(valid).build()
    }
}
