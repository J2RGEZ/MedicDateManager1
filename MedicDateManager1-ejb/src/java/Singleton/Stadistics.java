/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Startup;

/**
 *
 * @author forjaser
 */
@Singleton
@Startup
@LocalBean
public class Stadistics {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static int date;
    private static int carti;
    private static HashMap<String,Integer> cart;
    
    @Lock(LockType.READ)
    public static int getDate() {
        return date;
    }
    
    @Lock(LockType.WRITE)
    public static void addDate(){
        date++;
    }

    @Lock(LockType.READ)
    public static HashMap<String, Integer> getCart() {
        return new HashMap<>(cart);
    }
    
    @Lock(LockType.READ)
    public static int getCarti() {
        return carti;
    }

    @Lock(LockType.WRITE)
    public static void addCart(String s){
        if (cart.containsKey(s)) cart.put(s, cart.get(s)+1);
        else cart.put(s, 1);
    }
    
    @Lock(LockType.WRITE)
    public static void increaseCart(){
        carti++;
    }
    
    @PostConstruct
    public void init(){
        date=0;
        cart=new HashMap<>();
    }
}