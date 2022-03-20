package com.example.configservice.controllers;

import com.example.configservice.dto.BaseResponse;
import com.example.configservice.dto.HandlerException;
import com.example.configservice.model.Shop;
import com.example.configservice.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/shop/")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/register")
    public ResponseEntity<?> registerShop(@RequestBody Shop shop) {

        BaseResponse<Shop> response = new BaseResponse<>();
        response.setSuccess(false);
        try {
            Shop shop1 = shopService.save(shop);
            response.setData(shop1);
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return HandlerException.handlerException(e);
        }
    }
}
