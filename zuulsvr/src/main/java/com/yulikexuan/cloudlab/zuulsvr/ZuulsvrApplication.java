//: com.yulikexuan.cloudlab.zuulsvr.ZuulsvrApplication.java


package com.yulikexuan.cloudlab.zuulsvr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulsvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulsvrApplication.class, args);
    }

}///:~