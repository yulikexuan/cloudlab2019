//: com.yulikexuan.cloudlab.curconv.api.v1.mappers.ICurrencyConversionMapper.java


package com.yulikexuan.cloudlab.curconv.api.v1.mappers;


import com.yulikexuan.cloudlab.curconv.api.v1.model.CurrencyConversionDTO;
import com.yulikexuan.cloudlab.curconv.domain.model.CurrencyConversion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ICurrencyConversionMapper {

    ICurrencyConversionMapper INSTANCE = Mappers.getMapper(
            ICurrencyConversionMapper.class);

    CurrencyConversionDTO currencyConversionToCurrencyConversionDTO(
            CurrencyConversion currencyConversion);

}///:~