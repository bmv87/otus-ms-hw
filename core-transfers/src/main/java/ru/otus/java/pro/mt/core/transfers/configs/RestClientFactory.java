package ru.otus.java.pro.mt.core.transfers.configs;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;

import java.time.Duration;

public class RestClientFactory {

    public static RestClient createRestClient(RestClientProperties clientProperties) {
        return RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl(clientProperties.getUrl())
                .requestFactory(getClientHttpRequestFactory(clientProperties.getConnectTimeout(), clientProperties.getReadTimeout()))
                .build();
    }

    private static ClientHttpRequestFactory getClientHttpRequestFactory(Duration connectTimeout, Duration readTimeout) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        return clientHttpRequestFactory;
    }
}
