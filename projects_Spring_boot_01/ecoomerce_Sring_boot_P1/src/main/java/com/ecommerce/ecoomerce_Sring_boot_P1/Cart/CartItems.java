package com.ecommerce.ecoomerce_Sring_boot_P1.Cart;

import com.ecommerce.ecoomerce_Sring_boot_P1.Product.Entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cart_items_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private boolean status;

}
