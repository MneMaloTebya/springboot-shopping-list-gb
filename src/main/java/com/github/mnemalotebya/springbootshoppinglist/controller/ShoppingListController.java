package com.github.mnemalotebya.springbootshoppinglist.controller;
import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;
import com.github.mnemalotebya.springbootshoppinglist.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("items", shoppingListService.findAll());
        model.addAttribute("item", new Product());
        return "index";
    }

    @PostMapping
    public String addProduct(Product product) {
        shoppingListService.save(product);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        shoppingListService.delete(id);
        return "redirect:/";
    }
}
