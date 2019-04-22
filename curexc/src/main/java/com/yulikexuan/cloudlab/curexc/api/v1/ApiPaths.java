//: com.yulikexuan.cloudlab.curexc.api.v1.ApiPaths.java


package com.yulikexuan.cloudlab.curexc.api.v1;


import com.yulikexuan.cloudlab.curexc.api.v1.model.ExchangeValueDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;


public class ApiPaths {

    public static final String API_PATH_ROOT = "/api/v1/curexc";
    public static final String API_PATH_EXCHANGE_VALUE = "/from/{from}/to/{to}";

    public static ExchangeValueDTO configExchangeValueUri(ExchangeValueDTO dto) {

        if (dto == null) {
            return null;
        }

        Map<String, Object> variables = Map.of(
                "from", dto.getFromCurrency(),
                "to", dto.getToCurrency());

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_PATH_ROOT)
                .path(API_PATH_EXCHANGE_VALUE)
                .buildAndExpand(variables)
                .toUri();

        dto.setUri(location.toString());

        return dto;
    }

}///:~