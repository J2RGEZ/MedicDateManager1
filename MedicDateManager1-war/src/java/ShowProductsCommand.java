
import Entities.Products;
import Facades.ProductsFacade;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author forjaser
 */
public class ShowProductsCommand extends FrontCommand {
    ProductsFacade products = takeProductsFacadeBean();
    @Override
    public void process() throws ServletException, IOException{
        int index = 0;
        if(request.getParameter("index") != null){
            index = Integer.parseInt(request.getParameter("index"));
        }
        List<Products> prod = products.findRange(new int[]{index, index+4});
        request.setAttribute("list", prod);
        request.setAttribute("index", index);
        forward("/adminProducts.jsp");
    }

    private ProductsFacade takeProductsFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProductsFacade) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/ProductsFacade!Facades.ProductsFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
