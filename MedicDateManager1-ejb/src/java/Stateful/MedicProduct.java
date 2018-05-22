/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateful;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author forjaser
 */
@Stateful
@LocalBean
public class MedicProduct {
    private String name;
    private int price;
    private String manufacturer;

    public MedicProduct() {
    }
    
    public MedicProduct(String name, int price, String manufacturer){
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    
}
