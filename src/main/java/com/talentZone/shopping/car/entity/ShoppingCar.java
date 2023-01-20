package com.talentZone.shopping.car.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Document(collection = "shopping-car")
public class ShoppingCar {

    @Id
    private String id;
    private List<ItemCar> itemsCar;


    public ShoppingCar(){
        this.itemsCar = new ArrayList<>();
    }

    public void addItemCar(ItemCar itemCar){
        if (itemsCar.contains(itemCar)){
            validateItemCarExistInList(itemCar);
        } else {
            this.itemsCar.add(itemCar);
        }
    }

    private void validateItemCarExistInList(ItemCar itemCar) {
        Optional<ItemCar> itemCarOptional = itemsCar.stream().filter(i -> i.equals(itemCar)).findAny();
        if (itemCarOptional.isPresent()){
            ItemCar itemCar1 = itemCarOptional.get();
            itemCar1.setQuantity(itemCar1.getQuantity()+1);
        }
    }


    public int totalInvoice(){
        return itemsCar.stream().mapToInt(ItemCar::getImportItem).sum();
    }

}
