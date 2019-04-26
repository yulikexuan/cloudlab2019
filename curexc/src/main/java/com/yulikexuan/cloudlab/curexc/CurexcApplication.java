//: com.yulikexuan.cloudlab.curexc.CurexcApplication.java


package com.yulikexuan.cloudlab.curexc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.yulikexuan.cloudlab.curexc.domain.services")
public class CurexcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurexcApplication.class, args);
    }

}///:~