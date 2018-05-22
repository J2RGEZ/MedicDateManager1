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
public class User {
    private String name;
    private String pass;
    private Cart cart = new Cart();

    public User() {
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }
   
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }     
}
