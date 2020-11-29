package dev.davinogueira.password.controllers

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

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
        val client = HttpClient.create(server.url)
        val request = HttpRequest.POST("/validate", PasswordRequest("DaviNogueira"))
        val response = client.toBlocking().retrieve(request, PasswordResponse::class.java)

        assertNotNull(response)
        assertFalse(response.valid)
    }
}