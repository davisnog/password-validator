package dev.davinogueira.password.controllers

import dev.davinogueira.password.validators.impl.ValidatorServiceImpl
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.inject.Inject
import javax.validation.Valid

@Controller("/")
class PasswordValidatorController {

    @Inject
    private lateinit var validatorService: ValidatorServiceImpl


    @Post("/validate")
    fun validate(@Body @Valid request: PasswordRequest) : HttpResponse<PasswordResponse>{
        return HttpResponse.ok(PasswordResponse(validatorService.isValid(request.password)))
    }
}