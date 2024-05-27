package com.example.lesson.controller;

import com.example.lesson.Entity.ProductsRecord;
import com.example.lesson.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductsRestController {
    @Autowired
    ProductsService productsService;

    @GetMapping(value = "/api/products")
    public ResponseEntity<List<ProductsRecord>> productManagement(){
       var list = productsService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }




}
