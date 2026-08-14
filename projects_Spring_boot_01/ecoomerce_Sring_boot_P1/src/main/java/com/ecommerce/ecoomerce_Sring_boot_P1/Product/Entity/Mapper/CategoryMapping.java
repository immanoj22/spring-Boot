package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Mapper;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Category;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.CategoryRequest;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.CategoryResponseDTO;

public class CategoryMapping {

    public CategoryResponseDTO entity_to_response(Category category){
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getCategoryName());
        return categoryResponseDTO;
    }

    public Category request_to_entity(CategoryRequest CategoryRequest){
        Category category=new Category();
        category.setCategoryName(CategoryRequest.getCategoryName());
        return category;
    }
}
