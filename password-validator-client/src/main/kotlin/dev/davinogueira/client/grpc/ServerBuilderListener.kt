package dev.davinogueira.client.grpc

import io.grpc.ServerBuilder
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import javax.inject.Singleton

@Singleton
class ServerBuilderListener : BeanCreatedEventListener<ServerBuilder<*>> {
    override fun onCreated(event: BeanCreatedEvent<ServerBuilder<*>>): ServerBuilder<*> {
        val builder = event.bean
        builder.maxInboundMessageSize(1024)
        return builder
    }
}