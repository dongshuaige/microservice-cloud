package com.sc.controller;

import com.sc.pojo.Product;
import com.sc.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author java
 * @create 2019-07-24 13:45
 * @desc
 * @ClassName
 **/
@RestController
public class ProductController_Feign {
    @Autowired
    private ProductClientService productClientService;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(@RequestBody Product product) throws Exception {
        return productClientService.add(product);
    }

    @RequestMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return productClientService.get(id);
    }

    @RequestMapping(value = "/consumer/product/list")
    public List<Product> list() throws Exception {
        return productClientService.list();
    }
}
