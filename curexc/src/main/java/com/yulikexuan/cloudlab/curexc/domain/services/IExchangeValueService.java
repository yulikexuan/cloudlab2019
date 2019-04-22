//: com.yulikexuan.cloudlab.curexc.domain.services.IExchangeValueService.java


package com.yulikexuan.cloudlab.curexc.domain.services;


import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeValue;

import java.util.Optional;


public interface IExchangeValueService {

    Optional<ExchangeValue> getExchangeValue(String fromCurrency, String toCurrency);

}///:~