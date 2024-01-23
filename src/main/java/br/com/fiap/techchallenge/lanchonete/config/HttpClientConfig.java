package br.com.fiap.techchallenge.lanchonete.config;


import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class HttpClientConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
