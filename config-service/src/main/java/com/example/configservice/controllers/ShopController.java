package com.example.configservice.controllers;

import com.example.configservice.dto.BaseResponse;
import com.example.configservice.dto.HandlerException;
import com.example.configservice.model.Shop;
import com.example.configservice.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

//    @Bean
//    public WebMvcConfigurer configurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//               registry.addMapping("/*").allowedOrigins("*");
//            }
//        };
//    }

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

    @GetMapping("/getShopId/{shopId}")
    public ResponseEntity<?> getShopById(@PathVariable("shopId")Long shopId) {
        BaseResponse<Shop> response = new BaseResponse<>();
        response.setSuccess(false);
        try {
            Shop shop1 = shopService.getById(shopId);
            response.setData(shop1);
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return HandlerException.handlerException(e);
        }
    }
}
