package com.iridescent.iridescent.ms.product.service.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IridescentMsProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IridescentMsProductServiceApplication.class, args);
    }

}
