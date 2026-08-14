package com.ecommerce.ecoomerce_Sring_boot_P1.commonUtlis;

import lombok.Data;


@Data
public class SuccessResponse<T> {
    private boolean success = true;
    private String message;
    private T result;
}