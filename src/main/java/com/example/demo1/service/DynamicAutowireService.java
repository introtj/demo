package com.example.demo1.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicAutowireService {
    private final Map<String, RegionService> servicesByCountryCode;

    @Autowired
    public DynamicAutowireService(List<RegionService> regionServices) {
        servicesByCountryCode = regionServices.stream()
                .collect(Collectors.toMap(RegionService::getISOCountryCode, Function.identity()));
    }

    public boolean isServerActive(String isoCountryCode, int serverId) {
        RegionService service = servicesByCountryCode.get(isoCountryCode);

        return service.isServerActive(serverId);
    }
}
