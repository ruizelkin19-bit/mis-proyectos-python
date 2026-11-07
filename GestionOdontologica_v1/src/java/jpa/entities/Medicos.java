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
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m"),
    @NamedQuery(name = "Medicos.findByMedIdentificacion", query = "SELECT m FROM Medicos m WHERE m.medIdentificacion = :medIdentificacion"),
    @NamedQuery(name = "Medicos.findByMedNombres", query = "SELECT m FROM Medicos m WHERE m.medNombres = :medNombres"),
    @NamedQuery(name = "Medicos.findByMedApellidos", query = "SELECT m FROM Medicos m WHERE m.medApellidos = :medApellidos")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MedIdentificacion")
    private String medIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MedNombres")
    private String medNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MedApellidos")
    private String medApellidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citMedico")
    private Collection<Citas> citasCollection;

    public Medicos() {
    }

    public Medicos(String medIdentificacion) {
        this.medIdentificacion = medIdentificacion;
    }

    public Medicos(String medIdentificacion, String medNombres, String medApellidos) {
        this.medIdentificacion = medIdentificacion;
        this.medNombres = medNombres;
        this.medApellidos = medApellidos;
    }

    public String getMedIdentificacion() {
        return medIdentificacion;
    }

    public void setMedIdentificacion(String medIdentificacion) {
        this.medIdentificacion = medIdentificacion;
    }

    public String getMedNombres() {
        return medNombres;
    }

    public void setMedNombres(String medNombres) {
        this.medNombres = medNombres;
    }

    public String getMedApellidos() {
        return medApellidos;
    }

    public void setMedApellidos(String medApellidos) {
        this.medApellidos = medApellidos;
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
        hash += (medIdentificacion != null ? medIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.medIdentificacion == null && other.medIdentificacion != null) || (this.medIdentificacion != null && !this.medIdentificacion.equals(other.medIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return medIdentificacion + " " + medNombres + " " + medApellidos;
    }
    
}
