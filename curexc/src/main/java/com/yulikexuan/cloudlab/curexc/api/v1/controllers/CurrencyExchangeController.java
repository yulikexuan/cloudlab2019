//: com.yulikexuan.cloudlab.curexc.api.v1.controllers.CurrencyExchangeController.java


package com.yulikexuan.cloudlab.curexc.api.v1.controllers;


import com.yulikexuan.cloudlab.curexc.api.v1.ApiPaths;
import com.yulikexuan.cloudlab.curexc.api.v1.mappers.IExchangeValueMapper;
import com.yulikexuan.cloudlab.curexc.api.v1.model.ExchangeValueDTO;
import com.yulikexuan.cloudlab.curexc.domain.services.IExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yulikexuan.cloudlab.curexc.api.v1.ApiPaths.API_PATH_EXCHANGE_VALUE;
import static com.yulikexuan.cloudlab.curexc.api.v1.ApiPaths.API_PATH_ROOT;


@RestController
@RequestMapping(API_PATH_ROOT)
public class CurrencyExchangeController {

    private final IExchangeValueService exchangeValueService;

    @Autowired
    public CurrencyExchangeController(
            IExchangeValueService exchangeValueService) {

        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping(API_PATH_EXCHANGE_VALUE)
    public ExchangeValueDTO getExchangeValue(@PathVariable String from,
                                             @PathVariable String to) {

        return this.exchangeValueService.getExchangeValue(from, to)
                .map(ev -> {
                    ExchangeValueDTO dto = IExchangeValueMapper.INSTANCE
                            .exchangeValueToExchangeValueDTO(ev);
                    return ApiPaths.configExchangeValueUri(dto);
                }).orElseThrow(() -> new NotFoundException(
                        String.format("%s to %s", from, to)));
    }

}///:~