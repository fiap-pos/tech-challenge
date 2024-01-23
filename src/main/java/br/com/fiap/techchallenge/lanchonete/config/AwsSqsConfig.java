package br.com.fiap.techchallenge.lanchonete.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.config.SqsListenerConfigurer;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AwsSqsConfig {

    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient, ObjectMapper objectMapper) {
        return SqsTemplate.builder().configureDefaultConverter(converter -> {
                    converter.setObjectMapper(objectMapper);
                }).sqsAsyncClient(sqsAsyncClient)
                .build();
    }

    @Bean
    SqsListenerConfigurer configurer(ObjectMapper objectMapper) {
        return registrar -> {
            registrar.setObjectMapper(objectMapper);
        };
    }
}
