//: com.yulikexuan.cloudlab.curconv.domain.model.ExchangeValue.java


package com.yulikexuan.cloudlab.curconv.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class ExchangeValue {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private String uri;

}///:~