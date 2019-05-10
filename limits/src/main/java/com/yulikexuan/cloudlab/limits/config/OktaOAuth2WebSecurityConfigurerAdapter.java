//: com.yulikexuan.cloudlab.limits.config.OktaOAuth2WebSecurityConfigurerAdapter.java


package com.yulikexuan.cloudlab.limits.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class OktaOAuth2WebSecurityConfigurerAdapter
        extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

}///:~