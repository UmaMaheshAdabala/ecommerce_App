package com.umesh.Ecom_App.repository;

import com.umesh.Ecom_App.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
