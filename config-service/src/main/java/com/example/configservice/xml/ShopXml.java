package com.example.configservice.xml;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "", propOrder = {
})

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopXml {
    @XmlElement(name = "item")
    private List<ItemXml> itemXmlList;


}
