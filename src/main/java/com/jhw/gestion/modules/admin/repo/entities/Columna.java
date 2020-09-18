/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.repo.entities;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
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
@Table(name = "columna", schema = ResourcesKanban.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_columna"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Columna.findAll", query = "SELECT c FROM Columna c"),
    @NamedQuery(name = "Columna.findByIdColumna", query = "SELECT c FROM Columna c WHERE c.idColumna = :idColumna"),
    @NamedQuery(name = "Columna.findByNombreColumna", query = "SELECT c FROM Columna c WHERE c.nombreColumna = :nombreColumna"),
    @NamedQuery(name = "Columna.findByDescripcion", query = "SELECT c FROM Columna c WHERE c.descripcion = :descripcion")})
public class Columna implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_columna", nullable = false)
    private Integer idColumna;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_columna", nullable = false, length = 100)
    private String nombreColumna;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    
    public Columna() {
    }

    public Columna(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public Columna(Integer idColumna, String nombreColumna, String descripcion) {
        this.idColumna = idColumna;
        this.nombreColumna = nombreColumna;
        this.descripcion = descripcion;
    }

    public Integer getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ColumnaProyecto> getColumnaProyectoList() {
        return columnaProyectoList;
    }

    public void setColumnaProyectoList(List<ColumnaProyecto> columnaProyectoList) {
        this.columnaProyectoList = columnaProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColumna != null ? idColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Columna)) {
            return false;
        }
        Columna other = (Columna) object;
        if ((this.idColumna == null && other.idColumna != null) || (this.idColumna != null && !this.idColumna.equals(other.idColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.admin.repo.entities.Columna[ idColumna=" + idColumna + " ]";
    }
    
}
