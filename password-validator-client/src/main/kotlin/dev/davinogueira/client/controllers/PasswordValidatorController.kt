package dev.davinogueira.client.controllers

import dev.davinogueira.client.service.PasswordValidatorService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid


@Controller("/")
class PasswordValidatorController(private val validatorService: PasswordValidatorService) {

    @Post("/validate")
    fun validate(@Body @Valid request: PasswordRequest) : PasswordResponse{
        return PasswordResponse(validatorService.isValid(request.password))
    }
}