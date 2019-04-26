//: com.yulikexuan.cloudlab.curconv.config.TracingConfig.java


package com.yulikexuan.cloudlab.curconv.config;


import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TracingConfig {

    @Bean
    public Sampler getDefaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}///:~