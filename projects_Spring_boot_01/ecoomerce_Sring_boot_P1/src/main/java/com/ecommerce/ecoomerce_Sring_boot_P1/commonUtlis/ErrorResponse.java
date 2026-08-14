package com.ecommerce.ecoomerce_Sring_boot_P1.commonUtlis;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;



@Data
public class ErrorResponse {
    private boolean success = false;
    private String message;
    private Map<String, String> errors; // field -> error message, or null
    private LocalDateTime timestamp;
}
