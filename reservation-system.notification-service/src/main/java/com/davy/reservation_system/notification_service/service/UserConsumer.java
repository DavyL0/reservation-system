package com.davy.reservation_system.notification_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.davy.reservation_system.notification_service.config.RabbitMQConfig.USER_QUEUE;

@Service
public class UserConsumer {
    @RabbitListener(queues = USER_QUEUE)
    public void consumerMEnsage(String message){
        System.out.println("📨 [Notification Service] Novo usuário criado: " + message);
    }
}
