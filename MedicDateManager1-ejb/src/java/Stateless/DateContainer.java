/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateless;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author forjaser
 */
@Stateless
@LocalBean
public class DateContainer {
    
    private ArrayList<MedicDate> container;

    public DateContainer() {
        container = new ArrayList<MedicDate>();
    }

    public ArrayList<MedicDate> getContainer() {
        return container;
    }

    public void setContainer(ArrayList<MedicDate> container) {
        this.container = container;
    }
    
    public void addDate(MedicDate medicDate){
        this.container.add(medicDate);
    }
    
}
