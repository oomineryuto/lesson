package com.example.lesson.service;

import com.example.lesson.Entity.ProductsRecord;

import java.util.List;

public interface IProductsService {
    List<ProductsRecord> findAll();
    ProductsRecord findById(int id);
    int insert(ProductsRecord productsRecord);
    int update(ProductsRecord productsRecord);
    int delete(int id);
}

