package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Service;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Category;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.CategoryRequest;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Mapper.CategoryMapping;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Product;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Exception.CommonError;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Repository.CategoryRepository;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Repository.ProductRespostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRespostory productRespostory;


    public List<Category> finallCategory() {
        return categoryRepository.findAll();
    }

    public List<Product> findCategoryProduct(long categoryProduct) {
        Optional<Category> category=categoryRepository.findById(categoryProduct);

        if(!category.isPresent()){
            throw new CommonError("invalid category");
        }

        Category cat=category.get();
        return productRespostory.findByProductCategory_CategoryId(cat.getCategoryId());
    }


    public Category addCategory(CategoryRequest categoryRequest) {
        Category category=new CategoryMapping().request_to_entity(categoryRequest);
        Category isExist=categoryRepository.findByCategoryName(category.getCategoryName());

        if(isExist.getCategoryName().equals(category.getCategoryName())){
            throw new CommonError("Allready category exists");
        }
        return categoryRepository.save(category);

    }
}
