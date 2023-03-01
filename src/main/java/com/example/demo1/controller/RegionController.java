package com.example.demo1.controller;

import com.example.demo1.service.DynamicAutowireService;
import com.example.demo1.service.RegionServiceV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {

    private final RegionServiceV1 regionServiceV1;
    private final DynamicAutowireService dynamicAutowireService;

    public RegionController(RegionServiceV1 regionServiceV1,
                            DynamicAutowireService dynamicAutowireService) {
        this.regionServiceV1 = regionServiceV1;
        this.dynamicAutowireService = dynamicAutowireService;
    }


    @GetMapping(path = "/v1/region/status")
    public boolean getRegionStatusV1(@RequestParam(name = "country_cd") String countryCd) {
        return this.regionServiceV1.isServerActive(countryCd, 1);
    }

    @GetMapping(path = "/v2/region/status")
    public boolean getRegionStatus(@RequestParam(name = "country_cd") String countryCd) {
        return this.dynamicAutowireService.isServerActive(countryCd, 1);
    }
}
