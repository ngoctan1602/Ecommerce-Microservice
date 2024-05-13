package com.tantan.ProductService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
    public String getNameProduct()
    {
        log.info("product");
        return "Hello Product";
    }
}
