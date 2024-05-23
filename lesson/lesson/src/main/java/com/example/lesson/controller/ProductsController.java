package com.example.lesson.controller;

import com.example.lesson.Entity.InsertProduct;
import com.example.lesson.Entity.ProductsRecord;
import com.example.lesson.LessonApplication;
import com.example.lesson.form.AddForm;
import com.example.lesson.service.IProductsService;
import com.example.lesson.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/product-add")
    public String index(@ModelAttribute("AddForm") AddForm addForm) {
        return "product-add";
    }
    @PostMapping("/product-add")
    public String insert (@Validated @ModelAttribute("AddForm") AddForm addForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/product-add";
        }else {
            productsService.insert(new InsertProduct(addForm.getName(),addForm.getPrice()));

            return "redirect:/product-list";
        }
    }
    @GetMapping("/update/{id}")
    public String index2(@ModelAttribute("AddForm") AddForm addForm,@PathVariable("id") int id,Model model) {
        model.addAttribute("product",productsService.findById(id));
        return "update";
    }
    @PostMapping("/update/{id}")
    public String update (@PathVariable("id") int id,@Validated @ModelAttribute("AddForm") AddForm addForm, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()) {
            model.addAttribute("product",productsService.findById(id));
            return "/update";
        }else {
            productsService.update(new ProductsRecord(id,addForm.getName(),addForm.getPrice()));

            return "redirect:/product-list";
        }
    }
}




