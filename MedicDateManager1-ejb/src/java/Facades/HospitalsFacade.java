/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Hospitals;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author forjaser
 */
@Stateless
public class HospitalsFacade extends SuperFacade<Hospitals> {
    @PersistenceContext(unitName = "MedicDateManager1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HospitalsFacade() {
        super(Hospitals.class);
    }
}