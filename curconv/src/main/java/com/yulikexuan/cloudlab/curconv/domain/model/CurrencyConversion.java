//: com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion.java


package com.yulikexuan.cloudlab.curconv.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class CurrencyConversion {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;

    public BigDecimal getTotalCalculatedAmount() {
        return this.conversionMultiple.multiply(this.quantity);
    }

}///:~