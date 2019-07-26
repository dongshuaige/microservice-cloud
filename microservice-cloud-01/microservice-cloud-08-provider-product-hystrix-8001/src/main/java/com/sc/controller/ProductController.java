package com.sc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.pojo.Product;
import com.sc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author java
 * @create 2019-07-23 11:24
 * @desc 服务提供者 控制层
 * @ClassName
 **/
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) throws Exception {
        return productService.add(product);
    }

    //当get方法出现异常时，则会调用hystrixGet方法处理
    //处理方法的返回值和参数类型要一致
    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) throws Exception {
        Product product = productService.get(id);
        if (product==null){
            log.info("ID="+id+"无效");
            throw new RuntimeException("ID="+id+"无效");
        }
        return product;
    }

    //当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
    public Product getFallback(@PathVariable("id") Long id) {
        return new Product(id, "ID=" + id + "无效数据@HystrixCommand", "无有效数据库");
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() throws Exception {
        return productService.list();
    }

}
