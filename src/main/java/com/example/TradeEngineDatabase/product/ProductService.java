package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.clientorder.ClientOrder;
import com.example.TradeEngineDatabase.clientorder.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductById(product.getProductId());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Id already taken.");
        }
        productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Product with id: "+productId+" does not exist.");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, Integer quantity) {
        Product product = productRepository.findProductById(productId).orElseThrow(() -> new IllegalStateException("Product with id " + productId + " does not exist."));

        if(quantity != null && !Objects.equals(product.getQuantity(),quantity)){
            product.setQuantity(quantity);
        }
    }
}
