//: com.yulikexuan.cloudlab.curconv.domain.services.ICurrencyExchangeService.java


package com.yulikexuan.cloudlab.curconv.domain.services;


import com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion;

import java.util.Optional;


public interface ICurrencyExchangeService {

    String API_PATH_EXCHANGE_VALUE =
            "http://localhost:8001/api/v1/curexc/from/{from}/to/{to}";

    Optional<CurrencyConversion> getExchangeValue(
            String fromCurrency, String toCurrency);

}///:~