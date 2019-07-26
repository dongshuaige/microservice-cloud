package com.sc.controller;

import com.sc.pojo.Product;
import com.sc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author java
 * @create 2019-07-23 11:24
 * @desc 服务提供者 控制层
 * @ClassName
 **/
//如果需要在自定义类中获取更新配置内容,则需要在此类上添加 @RefreshScope 才会获得更新的内容
@RefreshScope //用于刷新配置
@RestController
public class ProductController {
    
    @Value("${emp.name}")
    private String name;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) throws Exception {
        return productService.add(product);
    }

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) throws Exception {
        return productService.get(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() throws Exception {
        return productService.list();
    }

    @RequestMapping("/hello")
    public String getName(){
       return name;
    }
}
