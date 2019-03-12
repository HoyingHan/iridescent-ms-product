package com.iridescent.ms.product.service.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author  陌北有棵树
 * @version 2019/3/11
 */


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.iridescent.ms.product"})
public class IridescentMsProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IridescentMsProductServiceApplication.class, args);
    }

}
