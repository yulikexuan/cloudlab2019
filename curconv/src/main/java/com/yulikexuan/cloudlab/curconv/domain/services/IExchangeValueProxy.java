//: com.yulikexuan.cloudlab.curconv.domain.services.IExchangeValueProxy.java


package com.yulikexuan.cloudlab.curconv.domain.services;


import com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// @FeignClient(name = "conexc", url = "localhost:8001")
@FeignClient(name = "curexc")
@RibbonClient(name = "curexc")
public interface IExchangeValueProxy {

    @GetMapping("/api/v1/curexc/from/{from}/to/{to}")
    CurrencyConversion getExchangeValue(
            @PathVariable("from") String from, @PathVariable("to") String to);

}///:~