package net.example.demo.service;

import net.example.demo.entity.Product;
import net.example.demo.exception.ProductNotFoundException;
import net.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setId(productDetails.getId());
        product.setName(productDetails.getName());
        product.SetDescription(productDetails.GetDescription());
        product.setPrice(productDetails.getPrice());
        product.setSize(productDetails.getSize());
        product.setColor(productDetails.getColor());
        product.setQuantity(productDetails.getQuantity());
        product.setActive(productDetails.isActive());


        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
    public List<Product> filterProducts(String name, Double minPrice, Double maxPrice, Boolean active, String size, String color) {
        if (name != null && minPrice != null && maxPrice != null) {
            return productRepository.findByNameContainingAndPriceBetweenAndActive(name, minPrice, maxPrice, active);
        } else if (size != null && color != null) {
            return productRepository.findBySizeAndColorAndActive(size, color, active);
        }
        return productRepository.findAll();
    }
    public List<Product> searchProducts(String query) {
        return productRepository.findByNameContainingOrDescriptionContaining(query, query);
    }
    public List<Product> sortProducts(String sortBy) {
        return productRepository.findAll(Sort.by(sortBy));
    }
}
