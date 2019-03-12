package com.iridescent.ms.product.service.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 *
 * @author  陌北有棵树
 * @version 2019/3/11
 */


@SpringBootApplication
@EnableDiscoveryClient
public class IridescentMsProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IridescentMsProductServiceApplication.class, args);
    }

}
