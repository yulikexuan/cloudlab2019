//: com.yulikexuan.cloudlab.curexc.bootstrap.DefaultLoader.java


package com.yulikexuan.cloudlab.curexc.bootstrap;


import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeIdentity;
import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeValue;
import com.yulikexuan.cloudlab.curexc.domain.repositories.IExchangeValueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;


@Slf4j
@RefreshScope
@Configuration
public class DefaultLoader implements CommandLineRunner {

    @Value("${curexc.usd.cad}")
    private String curexcUsdCad;

    @Value("${curexc.usd.cny}")
    private String curexcUsdCny;

    @Value("${curexc.usd.hkd}")
    private String curexcUsdHkd;

    @Value("${curexc.cad.cny}")
    private String curexcCadCny;

    private final IExchangeValueRepository exchangeValueRepository;

    @Autowired
    public DefaultLoader(IExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.exchangeValueRepository.count() > 0) {
            return;
        }

        // Load exchange values
        ExchangeIdentity usdToCad = ExchangeIdentity.builder()
                .fromCurrency("USD")
                .toCurrency("CAD")
                .build();
        ExchangeValue usdToCadExchange = ExchangeValue.builder()
                .exchangeIdentity(usdToCad)
                .conversionMultiple(new BigDecimal(this.curexcUsdCad))
                .build();

        this.exchangeValueRepository.save(usdToCadExchange);

        ExchangeIdentity usdToCny = ExchangeIdentity.builder()
                .fromCurrency("USD")
                .toCurrency("CNY")
                .build();
        ExchangeValue usdToCnyExchange = ExchangeValue.builder()
                .exchangeIdentity(usdToCny)
                .conversionMultiple(new BigDecimal(this.curexcUsdCny))
                .build();

        this.exchangeValueRepository.save(usdToCnyExchange);

        ExchangeIdentity cadToCny = ExchangeIdentity.builder()
                .fromCurrency("CAD")
                .toCurrency("CNY")
                .build();
        ExchangeValue cadToCnyExchange = ExchangeValue.builder()
                .exchangeIdentity(cadToCny)
                .conversionMultiple(new BigDecimal(this.curexcCadCny))
                .build();

        this.exchangeValueRepository.save(cadToCnyExchange);

        ExchangeIdentity usdToHkd = ExchangeIdentity.builder()
                .fromCurrency("USD")
                .toCurrency("HKD")
                .build();
        ExchangeValue usdToHkdExchange = ExchangeValue.builder()
                .exchangeIdentity(usdToHkd)
                .conversionMultiple(new BigDecimal(this.curexcUsdHkd))
                .build();

        this.exchangeValueRepository.save(usdToHkdExchange);

        log.info(">>>>>>> {} exchange values loaded.",
                this.exchangeValueRepository.count());
    }

}///:~