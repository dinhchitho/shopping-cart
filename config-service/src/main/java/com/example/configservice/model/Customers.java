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
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Carts> cartId = new ArrayList<>();

    @OneToMany(mappedBy = "cartItemCustomerId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CartItems> cartItemCustomerId = new ArrayList<>();
}
