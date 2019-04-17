//: com.yulikexuan.cloudlab.limits.api.v1.model.LimitsConfigurationDTO.java


package com.yulikexuan.cloudlab.limits.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class LimitsConfigurationDTO {

    @Builder.Default
    private int maximum = 0;

    @Builder.Default
    private int minimum = 10_000;

}///:~