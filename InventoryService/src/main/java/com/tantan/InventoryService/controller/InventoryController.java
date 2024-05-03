package com.tantan.InventoryService.controller;

import com.tantan.InventoryService.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private  final ProductClient productClient;

    public InventoryController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/")
    private String getInventory()
    {
       String nameProduct =  productClient.getNameProduct();
       return "invetory" + nameProduct;
    }
}
