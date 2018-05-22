/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Stateful.Cart;
import Stateful.MedicProduct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author forjaser
 */
@WebServlet(urlPatterns = {"/CartCommand"})
public class CartCommand extends FrontCommand {
    
    MedicProduct prod = takeMedicProductBean();
    Cart cart = takeCartBean();
    
    @Override
    public void process() throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<MedicProduct> productos = (ArrayList<MedicProduct>) request.getSession().getAttribute("products");
        for(int i = 0; i < productos.size();i++){
            if (id == i){
                cart.addProductToCart(productos.get(i), productos.get(i).getPrice());
            }
        }
        request.getSession().setAttribute("carrito", cart);
    }

    private MedicProduct takeMedicProductBean() {
        try {
            Context c = new InitialContext();
            return (MedicProduct) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/MedicProduct!Stateful.MedicProduct");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
