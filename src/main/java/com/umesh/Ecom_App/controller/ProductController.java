package com.umesh.Ecom_App.controller;


import com.umesh.Ecom_App.model.Product;
import com.umesh.Ecom_App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/addProduct") // Adding product with image
    public ResponseEntity<?> addProductWithImage(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product p1;
        try{
            p1 = service.addaddProductWithImage(product,imageFile);
        }
        catch(Exception err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }

    @GetMapping("/products/{prodId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int prodId){
        Product p1 = service.getImageById(prodId);
        byte[] imageFile = p1.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(p1.getImageType())).body(imageFile);
    }

    @PutMapping("/product/update/{prodId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int prodId,  @RequestPart Product prod, @RequestPart MultipartFile imageFile) throws IOException {
        Product p = service.updateProduct(prodId, prod, imageFile);
        if(p!=null) return new ResponseEntity<>(p,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/product/delete/{prodId}")
    public ResponseEntity<String> deleteProductByid(@PathVariable int prodId ){
        service.deleteProductById(prodId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
