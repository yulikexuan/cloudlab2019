//: com.yulikexuan.cloudlab.curconv.api.v1.model.CurrencyConversionDTO.java


package com.yulikexuan.cloudlab.curconv.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class CurrencyConversionDTO {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private String uri;

}///:~