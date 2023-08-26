package com.crud.Inventory.controller;


import com.crud.Inventory.model.ProductDTO;
import com.crud.Inventory.service.BL.ProductServiceBL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceBL productServiceBL;

    public ProductController(ProductServiceBL productServiceBL) {
        this.productServiceBL = productServiceBL;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productServiceBL.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productServiceBL.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productServiceBL.createNewProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productServiceBL.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productServiceBL.deleteProduct(id);
    }
    @PostMapping("/{id}/update-stock")
    public ProductDTO updateStockCount(@PathVariable Long id, @RequestParam Long stockCount) {
        ProductDTO productDTO = productServiceBL.getProductById(id);

        if (productDTO != null) {
            long newStockCount = Math.max(productDTO.getStockCount() - stockCount, 0);
            productDTO.setStockCount(newStockCount);
            productServiceBL.updateProduct(id, productDTO);
        }

        return productDTO;
    }

    @GetMapping("/{id}/check-stock")
    public boolean checkStockAvailability(@PathVariable Long id, @RequestParam Long stockCount) {
        ProductDTO productDTO = productServiceBL.getProductById(id);

        if (productDTO != null) {
            return productDTO.getStockCount() >= stockCount;
        }

        return false;
    }

}
