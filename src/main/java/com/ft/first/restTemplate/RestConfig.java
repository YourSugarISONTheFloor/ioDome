package com.ft.first.restTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    //将RestTemplate注入近容器中
    @Bean
    public RestTemplate restTemplate(){
        //默认底层执行 HttpURLTemplate
        return new RestTemplate();
    }
}
