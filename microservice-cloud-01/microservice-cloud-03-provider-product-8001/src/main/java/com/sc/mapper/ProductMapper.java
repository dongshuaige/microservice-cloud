package com.sc.mapper;


import com.sc.pojo.Product;

import java.util.List;

/**
 * @author java
 * @desc
 * @ClassName
 **/
public interface ProductMapper {

    Product findById(Long pid)throws Exception;

    List<Product> findAll()throws Exception;

    boolean  addProduct(Product product)throws Exception;
}
