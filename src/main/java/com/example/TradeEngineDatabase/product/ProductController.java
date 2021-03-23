//package com.example.TradeEngineDatabase.product;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "api/v1/product")
//public class ProductController {
//    private final ProductService productService;
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/all")
//    public List<Product> getProducts() {
//        return productService.getProducts();
//    }
//
//    @PostMapping("/get")
//    public Product getProduct(@RequestBody Product product) throws IllegalStateException {
//
//        return productService.getProduct(product.getProductId());
//    }
//
//    @GetMapping("/portfolioId/{portfolioId}")
//    public List<Product> getProductsByPortfolio(@PathVariable("portfolioId") Long portfolioId){
//        return productService.getProductsInPortfolio(portfolioId);
//    }
//
//    @PostMapping("/new")
//    public void addNewProduct(@RequestBody Product product) throws IllegalStateException {
//        productService.addNewProduct(product);
//    }
//
//    @DeleteMapping("/delete/{productId}")
//    public void deleteProduct(@PathVariable("productId") Long productId) throws IllegalStateException {
//        productService.deleteProduct(productId);
//    }
//
//    @PutMapping("/update/{productId}")
//    public void updateProduct(
//            @PathVariable("productId") Long productId,
//            @RequestParam(required = false) Integer quantity,
//            @RequestParam(required = false) Double lastTradedPrice,
//            @RequestParam(required = false) String lastTradedSide
//    ) throws IllegalStateException {
//        productService.updateProduct(productId,quantity,lastTradedPrice,lastTradedSide);
//    }
//}
