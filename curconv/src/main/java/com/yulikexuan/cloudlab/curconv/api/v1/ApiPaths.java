//: com.yulikexuan.cloudlab.curconv.api.v1.ApiPaths.java


package com.yulikexuan.cloudlab.curconv.api.v1;


import com.yulikexuan.cloudlab.curconv.api.v1.model.CurrencyConversionDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class ApiPaths {

    public static final String API_PATH_ROOT = "/api/v1/curconv";
    public static final String API_PATH_CURRENCY_CONVERSION =
            "/from/{from}/to/{to}/quantity/{quantity}";

    public static CurrencyConversionDTO configExchangeValueUri(
            CurrencyConversionDTO dto) {

        if (dto == null) {
            return null;
        }

        Map<String, Object> variables = Map.of(
                "from", dto.getFromCurrency(),
                "to", dto.getToCurrency(),
                "quantity", dto.getQuantity());

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_PATH_ROOT)
                .path(API_PATH_CURRENCY_CONVERSION)
                .buildAndExpand(variables)
                .toUri();

        dto.setUri(location.toString());

        return dto;
    }

}///:~