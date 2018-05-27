/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Dates;
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
public class DatesFacade extends SuperFacade<Dates> {
    @PersistenceContext(unitName = "MedicDateManager1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatesFacade() {
        super(Dates.class);
    }
    
    public List<Dates> showDates(){
        String query="SELECT d FROM DATES d ORDER BY d.date DESC";
        return em.createQuery(query).getResultList();
    }
        
    public void updateDate(Dates date){
        String query="UPDATE Dates set username=:user,doctor=:doctor,dt=:date where id=:id";
        em.createQuery(query).setParameter("user",date.getUsername()).
                setParameter("date", date.getDt()).
                setParameter("doctor", date.getDoctor()).
                setParameter("id", date.getId()).executeUpdate();
    }
    
    public void removeDate(Dates date){
        String query= "DELETE FROM Dates where id=:id";
        em.createQuery(query).setParameter("id", date.getId()).executeUpdate();
    }
  
    public List<Dates> sortDates(){
       CriteriaBuilder crit = em.getCriteriaBuilder();
       CriteriaQuery<Dates> query = crit.createQuery(Dates.class);
       Root<Dates> root = query.from(Dates.class);
       query.select(root).orderBy(crit.asc(root.get("name")));
       return em.createQuery(query).getResultList();
    }
    
    public void addDate(Dates date){
        String query= "INSERT INTO DATES (USERNAME,DOCTOR,DT) VALUES (?,?,?)";
        em.createNativeQuery(query).setParameter(1, date.getUsername()).
                            setParameter(2, date.getDoctor()).
                            setParameter(3, date.getDt()).executeUpdate();
    }
}
