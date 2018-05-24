    
import Singleton.Log;
import Singleton.Stadistics;
import Stateful.User;
import Stateless.DateContainer;
import Stateless.Medic;
import Stateless.MedicDate;
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
public class ProcessDateCommand extends FrontCommand {
    
    User user = takeUserBean();
    MedicDate date = takeMedicDateBean();
    Medic medic = takeMedicBean();
    DateContainer container = takeDateContainerBean();
    Log log = takeLogBean();
    Stadistics stats = takeStadisticsBean();
    
    @Override
    public void process() throws ServletException, IOException{
        log.saveCommands("procesando citas");
        user = new User(request.getParameter("name"),request.getParameter("DNI"));
        date = new MedicDate(request.getParameter("date"), new Medic(request.getParameter("medic")), user);
        container.addDate(date);
        request.getSession().setAttribute("medicDate", container);
        stats.addDate();
        forward("/successPage.jsp");
    }
    
    private User takeUserBean() {
        try {
            Context c = new InitialContext();
            return (User) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/User!Stateful.User");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MedicDate takeMedicDateBean() {
        try {
            Context c = new InitialContext();
            return (MedicDate) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/MedicDate!Stateless.MedicDate");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Medic takeMedicBean() {
        try {
            Context c = new InitialContext();
            return (Medic) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/Medic!Stateless.Medic");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private DateContainer takeDateContainerBean() {
        try {
            Context c = new InitialContext();
            return (DateContainer) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/DateContainer!Stateless.DateContainer");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Log takeLogBean() {
        try {
            Context c = new InitialContext();
            return (Log) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/Log!Singleton.Log");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Stadistics takeStadisticsBean() {
        try {
            Context c = new InitialContext();
            return (Stadistics) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/Stadistics!Singleton.Stadistics");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
