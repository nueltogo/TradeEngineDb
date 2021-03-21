package com.example.TradeEngineDatabase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/get")
    public Product getProduct(@RequestBody Product product){
        return productService.getProduct(product.getProductId());
    }

    @PostMapping("/new")
    public void addNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/update/{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Double lastTradedPrice,
            @RequestParam(required = false) String lastTradedSide
    ) {
        productService.updateProduct(productId,quantity,lastTradedPrice,lastTradedSide);
    }
}
