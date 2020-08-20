package com.lhq.elastic.repository;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("jestClient")
public class MyJestClient {
    public JestClient MyJestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("39.101.170.233:9200").multiThreaded(true).build());
        return factory.getObject();
    }
}
