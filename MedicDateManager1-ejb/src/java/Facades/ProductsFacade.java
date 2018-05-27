/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author forjaser
 */
@Stateless
public class ProductsFacade extends SuperFacade<Products> {
    @PersistenceContext(unitName = "MedicDateManager1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
   
    public List<Products> searchProduct(String name){
        String query="SELECT p FROM Products p where p.name LIKE :name";
        return em.createQuery(query).setParameter("name", "%"+name+"%").getResultList();
    }
}