package com.umesh.Ecom_App.service;

import com.umesh.Ecom_App.model.Product;
import com.umesh.Ecom_App.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
    public List<Product> getProducts(){
        return repo.findAll();
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct() {
        repo.deleteAll();
    }
}
