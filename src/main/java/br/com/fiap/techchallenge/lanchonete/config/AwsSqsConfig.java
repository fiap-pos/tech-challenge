package br.com.fiap.techchallenge.lanchonete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSqsConfig {
    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(
            AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }
}
