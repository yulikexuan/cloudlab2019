//: com.yulikexuan.cloudlab.curexc.api.v1.model.ExchangeValueDTO.java


package com.yulikexuan.cloudlab.curexc.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class ExchangeValueDTO {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private String uri;

}///:~