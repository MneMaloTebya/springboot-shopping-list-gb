package com.github.mnemalotebya.springbootshoppinglist.service;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;

import java.util.List;

public interface ShoppingListService {
    void save(Product product);
    void delete(int id);
    List<Product> findAll();
}
