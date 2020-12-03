package dev.davinogueira.server.grpc

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class PasswordValidatorStrategyEndpointTest {

    @Inject
    lateinit var blockingStub: PasswordValidatorGrpc.PasswordValidatorBlockingStub

    @Test
    fun `test password is valid`(){
        val request = PasswordValidatorRequest.newBuilder().setValue("Dav1N0gu3ir@").build()
        Assertions.assertTrue(blockingStub.validate(request).valid)
    }

    @Test
    fun `test password is invalid`(){
        val request = PasswordValidatorRequest.newBuilder().setValue("DaviNogueira").build()
        Assertions.assertFalse(blockingStub.validate(request).valid)
    }
}