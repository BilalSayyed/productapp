package com.bca.service;

import com.bca.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Schedule {
    @Autowired
    private ProductService productService;
    @Scheduled(initialDelay = 5000,fixedDelay = 1500)
    public void invalidateCache()
    {
        productService.evictAll();
    }
}
