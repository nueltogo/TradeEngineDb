package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.portfolio.Portfolio;
import com.example.TradeEngineDatabase.portfolio.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          PortfolioRepository portfolioRepository) {
        this.productRepository = productRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public void addNewProduct(Product product) {
        long portfolioId = product.getPortfolioId();
        Portfolio portfolio = portfolioRepository.getOne(portfolioId);
        product.setPortfolio(portfolio);
        portfolio.setProducts(product);
        Optional<Product> productOptional = productRepository.findProductById(product.getProductId());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Id already taken.");
        }
        productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(long productId) {
        Optional<Product> productOptional = productRepository.findProductById(productId);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        throw new IllegalStateException("product does not exist.");
    }

    public List<Product> getProductsInPortfolio(long portfolioId){
        Optional<List<Product>> optionalProducts = productRepository.findByPortfolio_PortfolioId(portfolioId);
        if(optionalProducts.isPresent()){
            return optionalProducts.get();
        }
        throw new IllegalStateException("portfolio does not exist");
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Product with id: "+productId+" does not exist.");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, Integer quantity, Double lastTradedPrice, String lastTradedSide) {
        Product product = productRepository.findProductById(productId).orElseThrow(() -> new IllegalStateException("Product with id " + productId + " does not exist."));
        System.out.println("Updating");
        product.setQuantity(quantity);
        product.setLastTradedPrice(lastTradedPrice);
        product.setLastTradedSide(lastTradedSide);
    }
}
