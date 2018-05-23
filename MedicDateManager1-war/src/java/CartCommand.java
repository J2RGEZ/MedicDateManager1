/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Singleton.Log;
import Stateful.Cart;
import Stateful.MedicProduct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

/**
 *
 * @author forjaser
 */
public class CartCommand extends FrontCommand {
    
    Cart cart = takeCartBean();
    
    @Override
    public void process() throws ServletException, IOException {
        Cart cartTemp = (Cart) request.getSession().getAttribute("carrito");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<MedicProduct> productos = (ArrayList<MedicProduct>) request.getSession().getAttribute("products");
        if(cartTemp != null){ 
            for(int i = 0; i < productos.size();i++){
                if (id == i){
                    cartTemp.addProductToCart(productos.get(i), productos.get(i).getPrice());
                }
            }
            cart = cartTemp;
        }else {
            for(int i = 0; i < productos.size();i++){
                if (id == i){
                    cart.addProductToCart(productos.get(i), productos.get(i).getPrice());
                }
            }
        }
        request.getSession().setAttribute("carrito", cart);
        forward("/cart.jsp");
    }

    private Cart takeCartBean() {
        try {
            Context c = new InitialContext();
            return (Cart) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/Cart!Stateful.Cart");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
