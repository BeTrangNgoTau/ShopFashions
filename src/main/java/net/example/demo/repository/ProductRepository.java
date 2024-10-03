package net.example.demo.repository;


import net.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingAndPriceBetweenAndActive(
            String name,
            double minPrice,
            double maxPrice,
            boolean active
    );

    List<Product> findBySizeAndColorAndActive(
            String size,
            String color,
            boolean active
    );
    List<Product> findByNameContainingOrDescriptionContaining(
            String name,
            String description
    );
}
