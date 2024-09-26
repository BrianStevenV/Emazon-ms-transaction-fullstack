package com.FullStack.ms_transaction.infrastructure.configuration.feign.config;

import com.FullStack.ms_transaction.infrastructure.configuration.feign.CustomErrorDecoder;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.JwtRequestInterceptor;
import feign.Client;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Client feignClient(){
        return new ApacheHttpClient();
    }
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new JwtRequestInterceptor();
    }
    @Bean
    public ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
