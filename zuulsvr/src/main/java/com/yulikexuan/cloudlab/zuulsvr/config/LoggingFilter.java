//: com.yulikexuan.cloudlab.zuulsvr.config.LoggingFilter.java


package com.yulikexuan.cloudlab.zuulsvr.config;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Component
public class LoggingFilter extends ZuulFilter {

    public static final int FILTER_ORDER_LOGGING = 1;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER_LOGGING;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info(">>>>>>> Request: {} - URL: {}", request, request.getRequestURL());
        return null;
    }
}///:~