package net.example.demo.repository;

import net.example.demo.entity.Account;
import net.example.demo.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
     List<CartItem> findByAccount(Account account);
    // You can add custom query methods here if needed
}
