package com.example.lesson.service;

import com.example.lesson.Entity.ProductsRecord;
import com.example.lesson.Exception.ProductNotFoundException;
import com.example.lesson.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService{
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<ProductsRecord> findAll() {
        return productsRepository.findAll();
    }
    @Override
    public ProductsRecord findById(int id){
        if(productsRepository.findById(id) == null){
            throw new ProductNotFoundException();
         }else{
            return productsRepository.findById(id);
        }
    }
    @Override
    public int insert(ProductsRecord productsRecord){
        return productsRepository.insert(productsRecord);
    }
    @Override
    public int update(ProductsRecord productsRecord){
        return productsRepository.update(productsRecord);
    }
    @Override
    public int delete(int id){
        return productsRepository.delete(id);
    }





}
