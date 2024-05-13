package com.tantan.InventoryService.controller;

import com.tantan.InventoryService.client.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private  final ProductClient productClient;
    private static Logger log = LoggerFactory.getLogger(InventoryController.class);

    public InventoryController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/")
    @CircuitBreaker(name = "productService",
            fallbackMethod = "getCircuitBreak"
    )
//    @Cacheable(value = "inventoryCaching")
    public String getInventory()
    {
       String nameProduct =  productClient.getNameProduct();
       log.info("id");
       return "inventory" + nameProduct;
    }

    private String getCircuitBreak(Exception e)
    {
        return "Lỗi rồi bạn ơi. Bật lại sv hoặc cache dữ liệu cũ";
    }
}
