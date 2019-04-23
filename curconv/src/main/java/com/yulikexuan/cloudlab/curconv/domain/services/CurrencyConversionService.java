//: com.yulikexuan.cloudlab.curconv.domain.services.CurrencyConversionService.java


package com.yulikexuan.cloudlab.curconv.domain.services;


import com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Service
public class CurrencyConversionService implements ICurrencyConversionService {

    private final ICurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyConversionService(
            ICurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @Override
    public Optional<CurrencyConversion> getCurrencyConversion(
            String fromCurrency, String toCurrency, BigDecimal quantity) {

        return this.currencyExchangeService
                .getExchangeValue(fromCurrency, toCurrency)
                .map(cc -> {
                    cc.setQuantity(quantity);
                    return cc;
                });
    }

}///:~