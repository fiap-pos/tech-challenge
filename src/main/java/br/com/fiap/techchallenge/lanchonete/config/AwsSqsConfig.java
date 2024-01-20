package br.com.fiap.techchallenge.lanchonete.config;

import io.awspring.cloud.sqs.config.SqsBootstrapConfiguration;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Import(SqsBootstrapConfiguration.class)
@Configuration
public class AwsSqsConfig {

    private String accessKey = "admin";

    private String secretKey = "admin";

    private String region = "us-east-1";

    private String endpoint = "http://localhost:4566";
    @Bean
    SqsAsyncClient sqsAsyncClient(){
        return SqsAsyncClient
                .builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider
                        .create(AwsBasicCredentials.create(accessKey, secretKey)))
                .endpointOverride(URI.create(endpoint))
                .build();
    }

    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient){
        return SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .configure(options -> options
                        .acknowledgementMode(TemplateAcknowledgementMode.MANUAL)
                        .defaultQueue("sqsPagamentos"))
                .build();
    }
}
