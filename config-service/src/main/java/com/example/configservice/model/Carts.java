package com.example.configservice.model;

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
@Table(name = "carts")
public class Carts {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long CartId;

    @Column(name = "status")
    private String status;

    @Column(name = "delivery_information")
    private String deliveryInformation;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop cart_shop_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customerId;

    @OneToMany(mappedBy = "ItemCartId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CartItems> ItemCartId = new ArrayList<>();
}
