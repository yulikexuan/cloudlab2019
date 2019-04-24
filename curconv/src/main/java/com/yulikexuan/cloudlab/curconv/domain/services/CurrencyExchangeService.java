//: com.yulikexuan.cloudlab.curconv.domain.services.CurrencyExchangeService.java


package com.yulikexuan.cloudlab.curconv.domain.services;


import com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CurrencyExchangeService implements ICurrencyExchangeService {

    private final IExchangeValueProxy exchangeValueProxy;
    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public CurrencyExchangeService(IExchangeValueProxy exchangeValueProxy,
                                   RestTemplateBuilder restTemplateBuilder) {
        this.exchangeValueProxy = exchangeValueProxy;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public Optional<CurrencyConversion> getExchangeValue(String fromCurrency,
                                                         String toCurrency) {

        return Optional.ofNullable(this.exchangeValueProxy.getExchangeValue(
                fromCurrency, toCurrency));

//        Map<String, String> pathVariables =
//                Map.of("from", fromCurrency, "to", toCurrency);
//
//        ResponseEntity<CurrencyConversion> entity =
//                this.restTemplateBuilder.build().getForEntity(
//                        API_PATH_EXCHANGE_VALUE, CurrencyConversion.class,
//                        pathVariables);
//
//        return entity.getStatusCode().equals(HttpStatus.OK) ?
//                Optional.ofNullable(entity.getBody()) : Optional.empty();
    }

}///:~