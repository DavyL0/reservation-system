package com.davy.reservation_system.user_service.producer;
import com.davy.reservation_system.user_service.entities.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendUserCreated(User user) {
        amqpTemplate.convertAndSend(" userQueue", user.getUsername());
    }

}
