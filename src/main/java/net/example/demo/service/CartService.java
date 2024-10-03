package net.example.demo.service;

import net.example.demo.entity.Account;
import net.example.demo.entity.Cart;
import net.example.demo.entity.CartItem;
import net.example.demo.entity.Product;
import net.example.demo.exception.CartNotFoundException;
import net.example.demo.repository.AccountRepository;
import net.example.demo.repository.CartItemRepository;
import net.example.demo.repository.CartRepository;
import net.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private AccountRepository accountRepository;

    public void addToCart(Long userId, CartItem cartItem) {
        // Logic to add product to cart
        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
        Cart cart;

        if (optionalCart.isPresent()) {
            cart = optionalCart.get();
        } else {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setCreatedAt(LocalDateTime.now());
            cart.setUpdatedAt(LocalDateTime.now());
        }

        cartItem.setCart(cart);

        cart.getItems().add(cartItem);
        cartRepository.save(cart);
    }


    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException(userId));
    }

    public Cart addItemToCart(Long userId, CartItem item) {
        Cart cart = getCartByUserId(userId);
        // Add item to cart logic
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Cập nhật giỏ hàng theo ID
    public Cart updateCart(Long id, Cart cartDetails) {
        Cart cart = getCartById(id);


        // Lưu lại giỏ hàng đã cập nhật
        return cartRepository.save(cart);
    }

    private Cart getCartById(Long id){
        return cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
    }

    public List<CartItem> getCartItemsByUser(Account account) {
        return cartItemRepository.findByAccount(account); // Gọi phương thức đã sửa đổi
    }

    // Xóa giỏ hàng theo ID
    public void deleteCart(Long id) {
        Cart cart = getCartById(id);
        cartRepository.delete(cart);
    }
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public CartItem addProductToCart(Long userId, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Account account = accountRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setAccount(account);
        cartItem.setQuantity(quantity);

        return cartItemRepository.save(cartItem);
    }

    }




