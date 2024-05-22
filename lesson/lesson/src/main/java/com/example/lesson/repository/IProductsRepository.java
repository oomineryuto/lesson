package com.example.lesson.repository;

import com.example.lesson.Entity.InsertProduct;
import com.example.lesson.Entity.ProductsRecord;

import java.util.List;

public interface IProductsRepository {
    List<ProductsRecord> findAll();
    ProductsRecord findById(int id);
    int insert(InsertProduct insertProduct);
    int update(ProductsRecord productsRecord);
    int delete(int id);


}
