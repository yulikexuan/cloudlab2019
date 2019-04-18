//:com.yulikexuan.cloudlab.confsvr.ConfsvrApplication.java


package com.yulikexuan.cloudlab.confsvr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class ConfsvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfsvrApplication.class, args);
    }

}///:~