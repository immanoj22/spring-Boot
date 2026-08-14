package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Controller;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Category;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.DTO.CategoryRequest;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Product;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Repository.ProductRespostory;
import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Service.CategoryService;
import com.ecommerce.ecoomerce_Sring_boot_P1.commonUtlis.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;



    @GetMapping("")
    public ResponseEntity<SuccessResponse> getallcategory(){

        List<Category> all_category=categoryService.finallCategory();

        SuccessResponse successResponse=new SuccessResponse();
        successResponse.setResult(all_category);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getProduct(@PathVariable("id") long categoryProduct){

        List<Product>categoryProducts=categoryService.findCategoryProduct(categoryProduct);
        SuccessResponse successResponse=new SuccessResponse();
        successResponse.setResult(categoryProducts);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> addCategory(@RequestBody CategoryRequest categoryRequest){
       Category category= categoryService.addCategory(categoryRequest);
       SuccessResponse successResponse=new SuccessResponse<>();
       successResponse.setResult(category);
       return new ResponseEntity<>(successResponse,HttpStatus.CREATED);
    }



}
