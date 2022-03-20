package com.example.configservice.services;

import com.example.configservice.model.Shop;
import com.example.configservice.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }
}
