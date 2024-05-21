package com.example.lesson.controller;

import com.example.lesson.LessonApplication;
import com.example.lesson.service.IProductsService;
import com.example.lesson.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductsController {
    @Autowired
    ProductsService productsService;

   //こいつらわんちゃん悪さする。
    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello Spring";
    }
    @GetMapping("product-list")
    public String productList(Model model) {
        // ロジックをServiceに任せる
        model.addAttribute("productlist",productsService.findAll());
        return "product-list";
    }

    @GetMapping("product/{id}")
    public String product(@PathVariable("id") int id,Model model){
        model.addAttribute("product",productsService.findById(id));
        return "product";
    }




}