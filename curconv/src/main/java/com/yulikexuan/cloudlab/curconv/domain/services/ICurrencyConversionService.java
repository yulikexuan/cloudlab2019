//: com.yulikexuan.cloudlab.curconv.domain.services.ICurrencyConversionService.java


package com.yulikexuan.cloudlab.curconv.domain.services;


import com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion;

import java.math.BigDecimal;
import java.util.Optional;


public interface ICurrencyConversionService {

    Optional<CurrencyConversion> getCurrencyConversion(
            String fromCurrency, String toCurrency, BigDecimal quantity);

}///:~