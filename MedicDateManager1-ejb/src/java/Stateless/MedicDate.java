package Stateless;



import Stateful.User;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author forjaser
 */
@Stateless
@LocalBean
public class MedicDate {
    private String medicDate;
    private Medic medic;
    private User user;

    public MedicDate() {
    }

    public MedicDate(String medicDate, Medic medic, User user) {
        this.medicDate = medicDate;
        this.medic = medic;
        this.user = user;
    }

    public String getMedicDate() {
        return medicDate;
    }

    public Medic getMedic() {
        return medic;
    }

    public User getUser() {
        return user;
    }

    public void setMedicDate(String medicDate) {
        this.medicDate = medicDate;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
