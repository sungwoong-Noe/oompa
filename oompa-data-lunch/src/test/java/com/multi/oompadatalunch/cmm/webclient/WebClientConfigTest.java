package com.multi.oompadatalunch.cmm.webclient;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootTest
class WebClientConfigTest {

    @Autowired
    WebClient kakaoWebClient;

    @Test
    @DisplayName("카카오 API 테스트")
    public void kakaoApi() {

        String block = kakaoWebClient.get().uri(uriBuilder ->
                        uriBuilder.queryParam("query", "대전맛집")
                                .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("block = " + block);

    }


}