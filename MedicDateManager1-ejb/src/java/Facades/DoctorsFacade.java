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
    @PersistenceContext(unitName = "MedicDateManager-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoctorsFacade() {
        super(Doctors.class);
    }
}