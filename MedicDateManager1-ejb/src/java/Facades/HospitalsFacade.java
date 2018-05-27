/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Dates;
import Entities.Hospitals;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    
    public List<Hospitals> sortDates(){
       CriteriaBuilder crit = em.getCriteriaBuilder();
       CriteriaQuery<Hospitals> query = crit.createQuery(Hospitals.class);
       Root<Hospitals> root = query.from(Hospitals.class);
       query.select(root).orderBy(crit.asc(root.get("name")));
       return em.createQuery(query).getResultList();
    }
    
    public void addHospital(Hospitals hospital){
        String query= "INSERT INTO Hospitals (name,location,specialty) VALUES (?,?,?)";
        em.createNativeQuery(query).setParameter(1, hospital.getName()).
                            setParameter(2, hospital.getLocation()).
                            setParameter(3, hospital.getSpecialty()).executeUpdate();
    }
}