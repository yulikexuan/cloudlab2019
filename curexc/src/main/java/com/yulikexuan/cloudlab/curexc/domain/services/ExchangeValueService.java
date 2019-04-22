//: com.yulikexuan.cloudlab.curexc.domain.services.ExchangeValueService.java


package com.yulikexuan.cloudlab.curexc.domain.services;


import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeIdentity;
import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeValue;
import com.yulikexuan.cloudlab.curexc.domain.repositories.IExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ExchangeValueService implements IExchangeValueService {

    private final IExchangeValueRepository exchangeValueRepository;

    @Autowired
    public ExchangeValueService(IExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public Optional<ExchangeValue> getExchangeValue(String fromCurrency,
                                                    String toCurrency) {

        ExchangeIdentity exchangeIdentity = ExchangeIdentity.builder()
                .fromCurrency(fromCurrency)
                .toCurrency(toCurrency)
                .build();

        return this.exchangeValueRepository.findById(exchangeIdentity);
    }

}///:~