
import Entities.Doctors;
import Facades.DoctorsFacade;
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
public class AddDoctorCommand extends FrontCommand {

    DoctorsFacade doctors = takeDoctorsFacadeBean();
    
    @Override
    public void process() throws ServletException, IOException {
        Doctors d = new Doctors();
        d.setHospital(request.getParameter("hospital"));
        d.setName(request.getParameter("name"));
        d.setSpecialty(request.getParameter("specialty"));
        doctors.addDoctor(d);
        forward("/adminHospitals.jsp");
    }

    private DoctorsFacade takeDoctorsFacadeBean() {
        try {
            Context c = new InitialContext();
            return (DoctorsFacade) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/DoctorsFacade!Facades.DoctorsFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
