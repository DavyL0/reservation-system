package com.davy.reservation_system.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {
    public static final String USER_QUEUE = "user_queue";

    @Bean
    public Queue userQueue() {
        return new Queue(USER_QUEUE, true);
    }
}
