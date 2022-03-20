package com.example.configservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long ShopId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String PhoneNumber;

    @Column(name = "image")
    private String image;

    @Column(name = "is_active")
    private boolean isActive;


    @OneToMany(mappedBy = "cart_shop_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Carts> cartShopId = new ArrayList<>();

    @OneToMany(mappedBy = "item_shop_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Item> itemShopId = new ArrayList<>();

}
