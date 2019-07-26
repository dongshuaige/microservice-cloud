package com.sc.service;

import com.sc.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author java
 * @create 2019-07-24 15:48
 * @desc   熔断处理类
 * @ClassName
 **/
@Component
public class ProductClientServiceFallBack implements ProductClientService {
    @Override
    public boolean add(Product product) throws Exception {
        return false;
    }

    @Override
    public Product get(Long id) {
        return new Product(id, "id=" + id + "无数据--feign&hystrix", "无有效数据库");
    }

    @Override
    public List<Product> list() throws Exception {
        return null;
    }
}
