package com.umesh.Ecom_App.service;

import com.umesh.Ecom_App.model.Product;
import com.umesh.Ecom_App.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addaddProductWithImage(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product getImageById(int prodId) {
        return repo.findById(prodId).get();
    }

    public Product updateProduct(int prodId, Product prod, MultipartFile imageFile) throws IOException {
        prod.setImageData(imageFile.getBytes());
        prod.setImageType(imageFile.getContentType());
        prod.setImageName(imageFile.getOriginalFilename());
        repo.save(prod);
        return prod;
    }

    public void deleteProductById(int prodId) {
        repo.deleteById(prodId);
    }
}
