//: com.yulikexuan.cloudlab.limits.api.config.LimitsConfiguration.java


package com.yulikexuan.cloudlab.limits.api.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Getter
@Setter
@RefreshScope
@Component
public class LimitsConfiguration {

    @Value("${limits.minimum}")
    private int minimum;

    @Value("${limits.maximum}")
    private int maximum;

}///:~