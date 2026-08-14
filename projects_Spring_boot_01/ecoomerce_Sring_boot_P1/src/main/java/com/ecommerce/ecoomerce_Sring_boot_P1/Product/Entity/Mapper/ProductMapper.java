package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Mapper;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Category;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.CategoryRequest;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.CategoryResponseDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.ProductRequestDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.ProductResponseDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Product;

public class ProductMapper {
    public ProductResponseDTO entity_to_response(Product product){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();

        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setAmount(product.getAmount());
        productResponseDTO.setProductCategory(product.getProductCategory());
        return productResponseDTO;
    }

    public Product request_to_entity(ProductRequestDTO productRequestDTO){

        Product product=new Product();
        product.setAmount(productRequestDTO.getAmount());
        product.setProductName(productRequestDTO.getProductName());
        product.setProductCategory(productRequestDTO.getProductCategory());
        return product;
    }
}
