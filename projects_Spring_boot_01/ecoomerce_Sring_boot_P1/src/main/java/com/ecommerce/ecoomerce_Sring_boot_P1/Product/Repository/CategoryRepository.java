package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Repository;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);
}
