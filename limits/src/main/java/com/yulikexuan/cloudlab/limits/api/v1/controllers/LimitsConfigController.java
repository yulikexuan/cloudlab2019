//: com.yulikexuan.cloudlab.limits.api.v1.controllers.LimitsConfigController.java


package com.yulikexuan.cloudlab.limits.api.v1.controllers;


import com.yulikexuan.cloudlab.limits.api.ApiPaths;
import com.yulikexuan.cloudlab.limits.api.config.LimitsConfiguration;
import com.yulikexuan.cloudlab.limits.api.v1.model.LimitsConfigurationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(ApiPaths.API_PATH_LIMITS_CONFIG)
public class LimitsConfigController {

    private final LimitsConfiguration limitsConfiguration;

    @Autowired
    public LimitsConfigController(LimitsConfiguration limitsConfiguration) {
        this.limitsConfiguration = limitsConfiguration;
    }

    @GetMapping
    public LimitsConfigurationDTO getLimitsConfig() {
        return LimitsConfigurationDTO.builder()
                .minimum(this.limitsConfiguration.getMinimum())
                .maximum(this.limitsConfiguration.getMaximum())
                .build();
    }

}///:~