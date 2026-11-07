/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "consultorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultorios.findAll", query = "SELECT c FROM Consultorios c"),
    @NamedQuery(name = "Consultorios.findByConNumero", query = "SELECT c FROM Consultorios c WHERE c.conNumero = :conNumero"),
    @NamedQuery(name = "Consultorios.findByConNombre", query = "SELECT c FROM Consultorios c WHERE c.conNombre = :conNombre")})
public class Consultorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ConNumero")
    private Integer conNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ConNombre")
    private String conNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citConsultorio")
    private Collection<Citas> citasCollection;

    public Consultorios() {
    }

    public Consultorios(Integer conNumero) {
        this.conNumero = conNumero;
    }

    public Consultorios(Integer conNumero, String conNombre) {
        this.conNumero = conNumero;
        this.conNombre = conNombre;
    }

    public Integer getConNumero() {
        return conNumero;
    }

    public void setConNumero(Integer conNumero) {
        this.conNumero = conNumero;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conNumero != null ? conNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultorios)) {
            return false;
        }
        Consultorios other = (Consultorios) object;
        if ((this.conNumero == null && other.conNumero != null) || (this.conNumero != null && !this.conNumero.equals(other.conNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return conNumero + " " + conNombre;
    }
    
}
