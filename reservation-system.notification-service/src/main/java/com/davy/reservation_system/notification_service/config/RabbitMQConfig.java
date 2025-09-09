package com.davy.reservation_system.notification_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {

    public static final String USER_QUEUE = "user_queue";

    @Bean
    public Queue queue() {
        return new Queue(USER_QUEUE, true);
    }
}
