
import Entities.Hospitals;
import Facades.DatesFacade;
import Facades.HospitalsFacade;
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
public class AddHospitalCommand extends FrontCommand {
    
    HospitalsFacade hospital = takeHospitalsFacadeBean();

    @Override
    public void process() throws ServletException, IOException {
        Hospitals h = new Hospitals();
        h.setLocation(request.getParameter("location"));
        h.setName(request.getParameter("name"));
        h.setSpecialty(request.getParameter("specialty"));
        hospital.addHospital(h);
        forward("/adminHospitals.jsp");
    }

    private HospitalsFacade takeHospitalsFacadeBean() {
        try {
            Context c = new InitialContext();
            return (HospitalsFacade) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/HospitalsFacade!Facades.HospitalsFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
