package com.example.configservice.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart_items")
public class CartItems {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long cartItemId;

    @Column(name = "amount")
    private int Amount;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers cartItemCustomerId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts ItemCartId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item ItemCartItemId;
}
