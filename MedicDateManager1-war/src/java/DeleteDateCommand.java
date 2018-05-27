
import Entities.Dates;
import Facades.DatesFacade;
import java.io.IOException;
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
public class DeleteDateCommand extends FrontCommand{

    DatesFacade dates = takeDatesFacadeBean();
    
    @Override
    public void process() throws ServletException, IOException {
        Dates d = new Dates();
        d.setId(Integer.parseInt(request.getParameter("id")));
        dates.removeDate(d);
        forward("/adminDates.jsp");
    }
    
    private DatesFacade takeDatesFacadeBean() {
        try {
            Context c = new InitialContext();
            return (DatesFacade) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/DatesFacade!Facades.DatesFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
