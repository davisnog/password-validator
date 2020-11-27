package dev.davinogueira.password.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class PasswordValidatorController {

    @Get("/hello/{name}")
    fun hello(name: String) : String {
        return "Hello $name!"
    }
}