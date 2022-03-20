package com.example.configservice.services;

import com.example.configservice.model.Item;
import com.example.configservice.model.Shop;
import com.example.configservice.repository.ItemRepository;
import com.example.configservice.repository.ShopRepository;
import com.example.configservice.xml.ItemXml;
import com.example.configservice.xml.ShopXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Shop save(Shop shop) {
        List<Shop> shopList = shopRepository.findAll();
        for (Shop shop1: shopList) {
            if (shop.getPhoneNumber().equals(shop1.getPhoneNumber())) {
                return null;
            }
        }
        Shop result = shopRepository.save(shop);
        List<ItemXml> itemXmlList = unmarshalling("File/item.xml").getItemXmlList();
        List<Item> itemList = new ArrayList<>();
        for (ItemXml itemXml:itemXmlList) {
            Item item = new Item();
            item.setActive(true);
            item.setName(itemXml.getName());
            item.setImage(itemXml.getImage());
            item.setPrice(itemXml.getPrice());
            item.setItem_shop_id(result);
            Item saveDbItem = itemRepository.save(item);
            itemList.add(saveDbItem);
        }
        return result;
    }

    //Get data từ file
    public ShopXml unmarshalling(String XmlPath) {
        ShopXml shopXml = new ShopXml();
        try {
            JAXBContext context = JAXBContext.newInstance(ShopXml.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            shopXml = ((ShopXml) unmarshaller.unmarshal(new File(XmlPath)));

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return shopXml;
    }

    public Shop getById(Long shopId) {
        return shopRepository.getById(shopId);
    }
}
