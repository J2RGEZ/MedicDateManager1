/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateful;

import java.util.HashMap;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author forjaser
 */
@Stateful
@LocalBean
public class Cart {
    private HashMap<MedicProduct, Integer> cart;
    
    public void addProductToCart(MedicProduct prod, int price){
        this.cart.put(prod, price);
    }

    public HashMap<MedicProduct, Integer> getCart() {
        return cart;
    }
    
}
