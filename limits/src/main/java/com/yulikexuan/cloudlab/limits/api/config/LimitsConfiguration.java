//: com.yulikexuan.cloudlab.limits.api.config.LimitsConfiguration.java


package com.yulikexuan.cloudlab.limits.api.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("limits")
public class LimitsConfiguration {

    private int minimum;
    private int maximum;

}///:~