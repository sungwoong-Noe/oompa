package com.multi.oompadatalunch.cmm.webclient;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.HandlerMapping;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;


@Slf4j
@Configuration
public class WebClientConfig {

    @Value("${kakao.rest.key}")
    private String restKey;

    private final HandlerMapping resourceHandlerMapping;
    public WebClientConfig(@Qualifier("resourceHandlerMapping") HandlerMapping resourceHandlerMapping) {
        this.resourceHandlerMapping = resourceHandlerMapping;
    }


    @Bean("kakaoWebClient")
    public WebClient kakaoWebClient(WebClient.Builder webClientBuilder) throws SSLException {


        //SSL 컨텍스트 생성 (모든 인증서 신뢰)
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();


        HttpClient httpClient = HttpClient.create()
                .secure(t -> t.sslContext(sslContext));



        return webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader("Authorization", restKey)
                .baseUrl("https://dapi.kakao.com/v2/local/search/keyword.json")
                .build();
    }




}
