

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entities.Dates;
import Facades.DatesFacade;
import Facades.UsersFacade;
import java.io.IOException;
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
public class AddDateCommand extends FrontCommand {

    DatesFacade dates = takeDatesFacadeBean();
    
    @Override
    public void process() throws ServletException, IOException {
        Dates d = new Dates(request.getParameter("date"));
        d.setDoctor(request.getParameter("doctor"));
        d.setUsername(request.getParameter("user"));
        dates.addDate(d);
        request.getSession().setAttribute("citas", dates);
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
