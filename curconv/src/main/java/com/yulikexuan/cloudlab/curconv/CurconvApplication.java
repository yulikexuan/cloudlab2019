//: com.yulikexuan.cloudlab.curconv.CurexcApplication.java


package com.yulikexuan.cloudlab.curconv;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.yulikexuan.cloudlab.curconv.domain.services")
public class CurconvApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurconvApplication.class, args);
    }

}///:~