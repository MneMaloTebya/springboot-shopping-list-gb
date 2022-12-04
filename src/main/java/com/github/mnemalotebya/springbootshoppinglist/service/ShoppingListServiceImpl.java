package com.github.mnemalotebya.springbootshoppinglist.service;

import com.github.mnemalotebya.springbootshoppinglist.model.ProductRepository;
import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServiceImpl implements ShoppingListService{

    private final ProductRepository productRepository;

    @Autowired
    public ShoppingListServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
