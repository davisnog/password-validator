package dev.davinogueira.password.controllers

import dev.davinogueira.password.validators.ValidatorsBuilder
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.inject.Inject
import javax.validation.Valid

@Controller("/")
class PasswordValidatorController {

    @Inject
    private lateinit var validatorsBuilder: ValidatorsBuilder


    @Post("/validate")
    fun validate(@Body @Valid request: PasswordRequest) : HttpResponse<PasswordResponse>{
        val paswd = validatorsBuilder.password()
        return HttpResponse.ok(PasswordResponse(paswd.isValid(request.password)))
    }
}