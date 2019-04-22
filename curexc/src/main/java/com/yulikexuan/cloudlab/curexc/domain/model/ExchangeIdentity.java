//: com.yulikexuan.cloudlab.curexc.domain.model.ExchangeIdentity.java


package com.yulikexuan.cloudlab.curexc.domain.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Builder @AllArgsConstructor
@Embeddable
public class ExchangeIdentity implements Serializable {

    @NotNull
    @Size(max = 3)
    @Column(name = "from_currency", length = 3, nullable = false)
    private String fromCurrency;

    @NotNull
    @Size(max = 3)
    @Column(name = "to_currency", length = 3, nullable = false)
    private String toCurrency;

}///:~