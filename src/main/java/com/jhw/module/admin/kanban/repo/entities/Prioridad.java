/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.repo.entities;

import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "prioridad", schema = ResourcesKanban.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_prioridad"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p"),
    @NamedQuery(name = "Prioridad.findByIdPrioridad", query = "SELECT p FROM Prioridad p WHERE p.idPrioridad = :idPrioridad"),
    @NamedQuery(name = "Prioridad.findByNombrePrioridad", query = "SELECT p FROM Prioridad p WHERE p.nombrePrioridad = :nombrePrioridad"),
    @NamedQuery(name = "Prioridad.findByDescripcion", query = "SELECT p FROM Prioridad p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Prioridad.findByColor", query = "SELECT p FROM Prioridad p WHERE p.color = :color")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prioridad", nullable = false)
    private Integer idPrioridad;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_prioridad", nullable = false, length = 100)
    private String nombrePrioridad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_comparable", nullable = false)
    private int valorComparable;

    @Basic(optional = false)
    @NotNull
    @Column(name = "color", nullable = false)
    private int color;

    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public Prioridad() {
    }

    public Prioridad(String nombrePrioridad, int valorComparable, int color, String descripcion) {
        this.nombrePrioridad = nombrePrioridad;
        this.valorComparable = valorComparable;
        this.color = color;
        this.descripcion = descripcion;
    }

    public Integer getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getValorComparable() {
        return valorComparable;
    }

    public void setValorComparable(int valorComparable) {
        this.valorComparable = valorComparable;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrioridad != null ? idPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.idPrioridad == null && other.idPrioridad != null) || (this.idPrioridad != null && !this.idPrioridad.equals(other.idPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.admin.repo.entities.Prioridad[ idPrioridad=" + idPrioridad + " ]";
    }

}
