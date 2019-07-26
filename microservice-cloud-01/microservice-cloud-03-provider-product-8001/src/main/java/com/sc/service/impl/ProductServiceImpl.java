package com.sc.service.impl;
import com.sc.service.ProductService;
import com.sc.mapper.ProductMapper;
import com.sc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author java
 * @create 2019-07-23 11:01
 * @desc
 * @ClassName
 **/

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean add(Product product) throws Exception {
        return productMapper.addProduct(product);
    }

    @Override
    public Product get(Long id) throws Exception {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> list() throws Exception {
        return productMapper.findAll();
    }
}
