//: com.yulikexuan.cloudlab.curconv.api.v1.controllers.CurrencyConversionController.java


package com.yulikexuan.cloudlab.curconv.api.v1.controllers;


import com.yulikexuan.cloudlab.curconv.api.v1.mappers.ICurrencyConversionMapper;
import com.yulikexuan.cloudlab.curconv.api.v1.model.CurrencyConversionDTO;
import com.yulikexuan.cloudlab.curconv.domain.services.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static com.yulikexuan.cloudlab.curconv.api.v1.ApiPaths.API_PATH_CURRENCY_CONVERSION;
import static com.yulikexuan.cloudlab.curconv.api.v1.ApiPaths.API_PATH_ROOT;


@RestController
@RequestMapping(API_PATH_ROOT)
public class CurrencyConversionController {

    private final ICurrencyConversionService currencyConversionService;

    @Autowired
    public CurrencyConversionController(
            ICurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping(API_PATH_CURRENCY_CONVERSION)
    public CurrencyConversionDTO convertCurrency(
            @PathVariable String from, @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        return this.currencyConversionService.getCurrencyConversion(from, to,
                        quantity)
                .map(ICurrencyConversionMapper.INSTANCE::
                        currencyConversionToCurrencyConversionDTO)
                .orElseThrow(() -> new NotFoundException(
                        String.format("%s to %s", from, to)));
    }

}///:~