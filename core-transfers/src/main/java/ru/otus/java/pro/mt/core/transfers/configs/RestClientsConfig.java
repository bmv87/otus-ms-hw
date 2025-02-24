package ru.otus.java.pro.mt.core.transfers.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;

@Configuration
public class RestClientsConfig {

    @Bean
    @ConfigurationProperties(prefix = "integrations.limits")
    public RestClientProperties limitsClientProperties() {
        return new RestClientProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "integrations.other")
    public RestClientProperties otherClientProperties() {
        return new RestClientProperties();
    }

    // @Bean
    public RestTemplate commonRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestClient limitsClient(RestClientProperties limitsClientProperties) {
        return RestClientFactory.createRestClient(limitsClientProperties);
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestClient otherClient(RestClientProperties otherClientProperties) {
        return RestClientFactory.createRestClient(otherClientProperties);
    }

}
