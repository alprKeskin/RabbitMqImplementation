package io.github.alprkeskin.producermicroservice.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private static final String QUEUE_POSTFIX = "-queue";
    private static final String EXCHANGE_POSTFIX = "-exchange";
    private static final String ROUTING_POSTFIX = "-routing";
    @Value("#{'producer-to-consumer'}")
    private String searchPrefix;

    @Bean
    public Declarables createRabbitQueuesConnection() {
        return new Declarables(createQueue(searchPrefix), createExchange(searchPrefix),
                createBindingRoute(searchPrefix));
    }

    /**
     * Creates a queue with name 'producer-to-consumer-queue'
     * To create queue, QUEUE_POSTFIX is used.
     * **/
    private Queue createQueue(String prefix) {
        return new Queue(prefix + QUEUE_POSTFIX, true);
    }

    /**
     * Creates an exchange with name 'producer-to-consumer-exchange'
     * To create exchange, EXCHANGE_POSTFIX is used.
     * **/
    private DirectExchange createExchange(String prefix) {
        return new DirectExchange(prefix + EXCHANGE_POSTFIX, true, false);
    }

    /**
     * Creates a route with the routing key 'producer-to-consumer-routing'
     * To create route, ROUTING_POSTFIX is used.
     * **/
    private Declarable createBindingRoute(String prefix) {
        return BindingBuilder.bind(createQueue(prefix)).to(createExchange(prefix)).with(prefix + ROUTING_POSTFIX);
    }
}
