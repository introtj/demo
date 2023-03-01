package com.example.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class RegionServiceV1 {

    public boolean isServerActive(String countryCd, int serverId) {
        if ("GB".equals(countryCd)) {
            return false;
        } else {
            return true;
        }
    }
}
