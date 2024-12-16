package com.umesh.Ecom_App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;

import java.math.BigDecimal;
import java.util.Date;

//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String  Name;
    private String description;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", releaseDate=" + releaseDate +
                ", available=" + available +
                ", quantity=" + quantity +
                '}';
    }
}
