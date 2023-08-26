package com.crud.Inventory.service.BL;

import com.crud.Inventory.model.ProductDTO;

import java.util.List;

public interface ProductServiceBL {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO createNewProduct(ProductDTO dto);

    ProductDTO updateProduct(Long id, ProductDTO dto);

    void deleteProduct(Long id);
}