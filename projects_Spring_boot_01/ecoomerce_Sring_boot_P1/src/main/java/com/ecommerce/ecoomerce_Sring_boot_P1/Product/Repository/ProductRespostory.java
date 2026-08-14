package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Repository;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespostory extends JpaRepository<Product,Long> {
    List<Product> findByProductCategory_CategoryId(long categoryId);
}
