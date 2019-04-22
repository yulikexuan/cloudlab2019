//: com.yulikexuan.cloudlab.curexc.api.v1.mappers.IExchangeValueMapper.java


package com.yulikexuan.cloudlab.curexc.api.v1.mappers;


import com.yulikexuan.cloudlab.curexc.api.v1.model.ExchangeValueDTO;
import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeIdentity;
import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface IExchangeValueMapper {

    IExchangeValueMapper INSTANCE = Mappers.getMapper(IExchangeValueMapper.class);

    @Mappings({
            @Mapping(target = "fromCurrency", source = "exchangeValue.fromCurrency"),
            @Mapping(target = "toCurrency", source = "exchangeValue.toCurrency")
    })
    ExchangeValueDTO exchangeValueToExchangeValueDTO(
            ExchangeValue exchangeValue);

    default ExchangeValue exchangeValueDTOToExchangeValue(
            ExchangeValueDTO exchangeValueDTO) {

        if (exchangeValueDTO == null) {
            return null;
        }

        ExchangeIdentity exchangeIdentity = ExchangeIdentity.builder()
                .fromCurrency(exchangeValueDTO.getFromCurrency())
                .toCurrency(exchangeValueDTO.getToCurrency())
                .build();

        return ExchangeValue.builder()
                .exchangeIdentity(exchangeIdentity)
                .conversionMultiple(exchangeValueDTO.getConversionMultiple())
                .build();
    }

}///:~