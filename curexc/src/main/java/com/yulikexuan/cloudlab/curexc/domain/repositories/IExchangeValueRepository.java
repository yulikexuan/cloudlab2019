//: com.yulikexuan.cloudlab.curexc.domain.repositories.IExchangeValueRepository.java


package com.yulikexuan.cloudlab.curexc.domain.repositories;


import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeIdentity;
import com.yulikexuan.cloudlab.curexc.domain.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IExchangeValueRepository
        extends JpaRepository<ExchangeValue, ExchangeIdentity> {

}///:~