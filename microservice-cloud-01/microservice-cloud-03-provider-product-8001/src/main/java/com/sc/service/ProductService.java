package com.sc.service;
import com.sc.pojo.Product;
import java.util.List;

/**
 * @author java
 * @desc
 * @ClassName
 **/
public interface ProductService {
    boolean add(Product product) throws Exception;

    Product get(Long id) throws Exception;

    List<Product> list() throws Exception;
}
