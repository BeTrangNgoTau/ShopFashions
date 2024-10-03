package net.example.demo.repository;

import org.springframework.stereotype.Repository;
import net.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
