/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author forjaser
 */
@Entity
@Table(name = "HOSPITALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospitals.findAll", query = "SELECT h FROM Hospitals h")
    , @NamedQuery(name = "Hospitals.findById", query = "SELECT h FROM Hospitals h WHERE h.id = :id")
    , @NamedQuery(name = "Hospitals.findByName", query = "SELECT h FROM Hospitals h WHERE h.name = :name")
    , @NamedQuery(name = "Hospitals.findBySpecialty", query = "SELECT h FROM Hospitals h WHERE h.specialty = :specialty")
    , @NamedQuery(name = "Hospitals.findByProducts", query = "SELECT h FROM Hospitals h WHERE h.products = :products")
    , @NamedQuery(name = "Hospitals.findByLocation", query = "SELECT h FROM Hospitals h WHERE h.location = :location")})
public class Hospitals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "SPECIALTY")
    private String specialty;
    @Size(max = 50)
    @Column(name = "PRODUCTS")
    private String products;
    @Size(max = 50)
    @Column(name = "LOCATION")
    private String location;

    public Hospitals() {
    }

    public Hospitals(Integer id) {
        this.id = id;
    }

    public Hospitals(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospitals)) {
            return false;
        }
        Hospitals other = (Hospitals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Hospitals[ id=" + id + " ]";
    }
    
}
