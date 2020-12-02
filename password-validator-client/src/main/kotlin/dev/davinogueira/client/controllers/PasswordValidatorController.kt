package dev.davinogueira.client.controllers

import dev.davinogueira.client.service.PasswordValidatorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.inject.Inject
import javax.validation.Valid


@Controller("/")
class PasswordValidatorController(private val validatorService: PasswordValidatorService) {

//    @Inject
//    private lateinit var validatorService: PasswordValidatorService

    @Post("/validate")
    fun validate(@Body @Valid request: PasswordRequest) : HttpResponse<PasswordResponse>{
        return HttpResponse.ok(PasswordResponse(validatorService.isValid(request.password)))
    }
}