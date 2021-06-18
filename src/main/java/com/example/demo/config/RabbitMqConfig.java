package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: istyak.rana
 * @date: 18-Jun-21
 */
@Configuration
public class RabbitMqConfig {

   /* @RabbitListener(queues = "salesman")
    public void getMessageFromBroker(Message<String> message){
        System.out.println("My message: ");
        System.out.println(message);
    }*/


//    @Bean
//    public Supplier<String> marketing() {
//        return () -> {
//            return "Hello World" + System.currentTimeMillis();
//        };
//    }
//
//    @Bean
//    public Consumer<String> salesman(){
//        return cm -> {
//            System.out.println(cm);
//        };
//    }


    @Bean
    public Function<Message<String>, Message<String>> mailer() {
        return inputMessage -> {
            String string = inputMessage.getPayload();
//            string.setResponseCode(Integer.toString(random.nextInt(100)));

            return MessageBuilder
                    .withPayload(string)
                    .setHeader("merchantKey", "string.getMerchantKey()")
                    .build();
        };
    }
}
