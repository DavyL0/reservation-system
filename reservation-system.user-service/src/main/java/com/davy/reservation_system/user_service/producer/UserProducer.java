package com.davy.reservation_system.user_service.producer;
import com.davy.reservation_system.user_service.entities.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static com.davy.reservation_system.user_service.config.RabbitMQConfig.USER_QUEUE;

@Service
public class UserProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendUserCreated(User user) {

        amqpTemplate.convertAndSend(USER_QUEUE, user.getUsername());
        System.out.println("Mensage sent to the queue: " + USER_QUEUE + " : " + user.getUsername());
    }

}
