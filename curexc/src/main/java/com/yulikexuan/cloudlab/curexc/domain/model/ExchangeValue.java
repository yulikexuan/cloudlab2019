//: com.yulikexuan.cloudlab.curexc.domain.model.ExchangeValue.java


package com.yulikexuan.cloudlab.curexc.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
@Entity
public class ExchangeValue {

    @EmbeddedId
    private ExchangeIdentity exchangeIdentity;

    @Column(name = "conversion_multiple")
    @NotNull
    private BigDecimal conversionMultiple;

    public String getFromCurrency() {
        return this.exchangeIdentity.getFromCurrency();
    }

    public String getToCurrency() {
        return this.exchangeIdentity.getToCurrency();
    }

}///:~