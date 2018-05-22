/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateless;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author forjaser
 */
@Stateless
@LocalBean
public class Medic {
    private String name;

    public Medic() {
    }
    
    public Medic(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
