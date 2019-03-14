package com.iridescent.ms.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author  陌北有棵树
 * @version 2019/3/11
 */


@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class IridescentMsProductServiceApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(IridescentMsProductServiceApplication.class, args);
        String[] beanNames = context.getBeanDefinitionNames();
        log.info("bean总数:{}", context.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
            log.info("{},beanName:{}", ++i, str);
        }
    }

}
