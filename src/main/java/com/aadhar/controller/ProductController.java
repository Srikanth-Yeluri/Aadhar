package com.aadhar.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhar.entity.Product;
import com.aadhar.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
//    @GetMapping("/name/{name}")
//    public Product getProductByName(@PathVariable String name) {
//        return service.getProductByName(name);
//    }
//    @GetMapping("/type/{productType}")
//    public List<Product> getProductsByType(@PathVariable String productType) {
//        return service.getProductsByType(productType);
//    }
//
//    @GetMapping("/price/{price}/type/{productType}")
//    public List<Product> getProductWithPriceAndType(@PathVariable double price,@PathVariable String productType) {
//        return service.getProductWithPriceAndType(price, productType);
//    }
//
//    @GetMapping("/search/{price}")
//    public List<Product> getProductByPrice(@PathVariable double price) {
//        return service.getProductsByPrice(price);
//    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
       return service.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public long deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    //operator
//
//    @PostMapping("/search")
//    public List<Product> getProductsByMultiplePriceValue(@RequestBody List<Double> prices){
//        return service.getProductsByMultiplePriceValue(prices);
//    }
//
//    @GetMapping("/min/{minPrice}/max/{maxPrice}")
//    public List<Product> getProductsWithinPriceRange(@PathVariable double minPrice,@PathVariable double maxPrice){
//        return service.getProductsWithinPriceRange(minPrice, maxPrice);
//    }
//
//    @GetMapping("/high/{price}")
//    public List<Product> getProductsWithHigherPrice(@PathVariable double price){
//        return service.getProductsWithHigherPrice(price);
//    }
//
//    @GetMapping("/less/{price}")
//    public List<Product> getProductsWithLessPrice(@PathVariable double price){
//        return service.getProductsWithLessPrice(price);
//    }
//
//    @GetMapping("/like/{name}")
//    public List<Product> getProductsWithLike(@PathVariable String name){
//        return service.getProductsWithLike(name);
//    }
//
//    //sorting
//    @GetMapping("/sort/{fieldName}")
//    public List<Product> getProductsWithSorting(@PathVariable String fieldName) {
//        return service.getProductsWithSorting(fieldName);
//    }
//
//    //pagination
//    @GetMapping("/page/{offset}/{limit}")
//    public Page<Product> getProductsWithPageResponse(@PathVariable int offset, @PathVariable int limit) {
//        return service.getProductsWithPageResponse(offset, limit);
//    }
//
//    //sorting & pagination
//    @GetMapping("/pageWithSort/{fieldName}/{offset}/{limit}")
//    public Page<Product> getProductsWithSortingAndPagination(@PathVariable String fieldName, @PathVariable int offset, @PathVariable int limit) {
//        return service.getProductsWithSortingAndPagination(fieldName, offset, limit);
//    }




}