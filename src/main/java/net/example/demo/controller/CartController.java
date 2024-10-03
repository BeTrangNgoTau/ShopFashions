package net.example.demo.controller;

import net.example.demo.entity.Cart;
import net.example.demo.entity.CartItem;
import net.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Void> addToCart(@PathVariable Long userId, @RequestBody CartItem cartItem) {
        cartService.addToCart(userId, cartItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/user/{userId}/items")
    public ResponseEntity<Cart> addItemToCart(
            @PathVariable Long userId,
            @RequestBody CartItem item) {
        Cart updatedCart = cartService.addItemToCart(userId, item);
        return ResponseEntity.ok(updatedCart);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        if (cart.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        return cartService.createCart(cart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(id, cartDetails);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public CartItem addProductToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addProductToCart(userId, productId, quantity);
    }

}
