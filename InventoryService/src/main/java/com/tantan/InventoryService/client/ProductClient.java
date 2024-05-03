package com.tantan.InventoryService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "inventory",url = "http://localhost:8080/product")
public interface ProductClient {
    @GetMapping("/")
    public String getNameProduct();
}
