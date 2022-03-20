package com.example.configservice.xml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "", propOrder = {
        "image",
        "name",
        "price"
})

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemXml {
    private String image;
    private String name;
    private double price;
}
