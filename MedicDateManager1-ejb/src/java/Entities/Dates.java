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
@Table(name = "APP.DATES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dates.findAll", query = "SELECT d FROM Dates d")
    , @NamedQuery(name = "Dates.findById", query = "SELECT d FROM Dates d WHERE d.id = :id")
    , @NamedQuery(name = "Dates.findByUsername", query = "SELECT d FROM Dates d WHERE d.username = :username")
    , @NamedQuery(name = "Dates.findByDoctor", query = "SELECT d FROM Dates d WHERE d.doctor = :doctor")
    , @NamedQuery(name = "Dates.findByDt", query = "SELECT d FROM Dates d WHERE d.dt = :dt")})
public class Dates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DOCTOR")
    private String doctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DT")
    private String dt;

    public Dates() {
    }

    public Dates(String dt) {
        this.dt = dt;
    }

    public Dates(Integer id, String username, String doctor, String dt) {
        this.id = id;
        this.username = username;
        this.doctor = doctor;
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
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
        if (!(object instanceof Dates)) {
            return false;
        }
        Dates other = (Dates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Dates[ id=" + id + " ]";
    }
    
}
