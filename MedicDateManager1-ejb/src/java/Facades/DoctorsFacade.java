/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Doctors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author forjaser
 */
@Stateless
public class DoctorsFacade extends SuperFacade<Doctors> {
    @PersistenceContext(unitName = "MedicDateManager1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoctorsFacade() {
        super(Doctors.class);
    }
    
    public void addDoctor(Doctors doctor){
        String query= "INSERT INTO Doctors (name,hospital,specialty) VALUES (?,?,?)";
        em.createNativeQuery(query).setParameter(1, doctor.getName()).
                            setParameter(2, doctor.getHospital()).
                            setParameter(3, doctor.getSpecialty()).executeUpdate();
    }
}