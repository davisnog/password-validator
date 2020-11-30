package dev.davinogueira.password.controllers

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class PasswordValidatorControllerTest {

    @Inject
    lateinit var server: EmbeddedServer

    @Test
    fun `test with valid password`() {
        val client = HttpClient.create(server.url)
        val request = HttpRequest.POST("/validate", PasswordRequest("AbTp9!fok"))
        val response = client.toBlocking().retrieve(request, PasswordResponse::class.java)

        assertNotNull(response)
        assertTrue(response.valid)
    }

    @Test
    fun `test with invalid password`() {
        var response = create("DaviNogueira")

        assertNotNull(response)
        assertFalse(response.valid)

        response = create("AbTp9!fok ")

        assertNotNull(response)
        assertFalse(response.valid)
    }

    private fun create(password: String) : PasswordResponse {
        val client = HttpClient.create(server.url)
        val request = HttpRequest.POST("/validate", PasswordRequest(password))
        return client.toBlocking().retrieve(request, PasswordResponse::class.java)
    }
}