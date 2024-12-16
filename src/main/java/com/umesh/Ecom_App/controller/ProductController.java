package com.umesh.Ecom_App.controller;


import com.umesh.Ecom_App.model.Product;
import com.umesh.Ecom_App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;
    @RequestMapping("/")
    public String greet(){
        return "Hello Dev..!!";
    }

    @GetMapping("/products")
     public List<Product> getProducts(){
        return service.getProducts();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product prod){
        System.out.println(prod);
        service.addProduct(prod);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(){
        service.deleteProduct();
    }
}
