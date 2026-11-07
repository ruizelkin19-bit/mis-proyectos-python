/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByCitNumero", query = "SELECT c FROM Citas c WHERE c.citNumero = :citNumero"),
    @NamedQuery(name = "Citas.findByCitFecha", query = "SELECT c FROM Citas c WHERE c.citFecha = :citFecha"),
    @NamedQuery(name = "Citas.findByCitHora", query = "SELECT c FROM Citas c WHERE c.citHora = :citHora"),
    @NamedQuery(name = "Citas.findByCitEstado", query = "SELECT c FROM Citas c WHERE c.citEstado = :citEstado")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CitNumero")
    private Integer citNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CitFecha")
    @Temporal(TemporalType.DATE)
    private Date citFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CitHora")
    private String citHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CitEstado")
    private String citEstado;
    @Column(name = "CitObservaciones")
    private String citObservaciones;
    @JoinColumn(name = "CitPaciente", referencedColumnName = "PacIdentificacion")
    @ManyToOne(optional = false)
    private Pacientes citPaciente;
    @JoinColumn(name = "CitMedico", referencedColumnName = "MedIdentificacion")
    @ManyToOne(optional = false)
    private Medicos citMedico;
    @JoinColumn(name = "CitConsultorio", referencedColumnName = "ConNumero")
    @ManyToOne(optional = false)
    private Consultorios citConsultorio;

    public Citas() {
    }

    public Citas(Integer citNumero) {
        this.citNumero = citNumero;
    }

    public Citas(Integer citNumero, Date citFecha, String citHora, String citEstado) {
        this.citNumero = citNumero;
        this.citFecha = citFecha;
        this.citHora = citHora;
        this.citEstado = citEstado;
    }

    public Integer getCitNumero() {
        return citNumero;
    }

    public void setCitNumero(Integer citNumero) {
        this.citNumero = citNumero;
    }

    public Date getCitFecha() {
        return citFecha;
    }

    public void setCitFecha(Date citFecha) {
        this.citFecha = citFecha;
    }

    public String getCitHora() {
        return citHora;
    }

    public void setCitHora(String citHora) {
        this.citHora = citHora;
    }

    public String getCitEstado() {
        return citEstado;
    }

    public void setCitEstado(String citEstado) {
        this.citEstado = citEstado;
    }

    public Pacientes getCitPaciente() {
        return citPaciente;
    }

    public void setCitPaciente(Pacientes citPaciente) {
        this.citPaciente = citPaciente;
    }

    public Medicos getCitMedico() {
        return citMedico;
    }

    public void setCitMedico(Medicos citMedico) {
        this.citMedico = citMedico;
    }

    public Consultorios getCitConsultorio() {
        return citConsultorio;
    }

    public void setCitConsultorio(Consultorios citConsultorio) {
        this.citConsultorio = citConsultorio;
    }

    public String getCitObservaciones() {
        return citObservaciones;
    }

    public void setCitObservaciones(String citObservaciones) {
        this.citObservaciones = citObservaciones;
    }

     
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citNumero != null ? citNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.citNumero == null && other.citNumero != null) || (this.citNumero != null && !this.citNumero.equals(other.citNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Citas[ citNumero=" + citNumero + " ]";
    }
    
}
