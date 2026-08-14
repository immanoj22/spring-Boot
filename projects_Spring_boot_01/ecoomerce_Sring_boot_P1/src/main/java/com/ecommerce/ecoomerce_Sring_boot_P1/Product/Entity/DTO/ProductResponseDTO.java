package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private String productName;

    private String amount;

    private List<Category> productCategory;

}
