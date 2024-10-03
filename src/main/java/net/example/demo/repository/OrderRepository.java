package net.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.example.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
