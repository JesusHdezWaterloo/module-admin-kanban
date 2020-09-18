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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "columna_proyecto", schema = ResourcesKanban.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"columna_fk", "proyecto_fk"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColumnaProyecto.findAll", query = "SELECT c FROM ColumnaProyecto c"),
    @NamedQuery(name = "ColumnaProyecto.findByIdColumnaProyecto", query = "SELECT c FROM ColumnaProyecto c WHERE c.idColumnaProyecto = :idColumnaProyecto"),
    @NamedQuery(name = "ColumnaProyecto.findByDescripcion", query = "SELECT c FROM ColumnaProyecto c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "ColumnaProyecto.findByOrden", query = "SELECT c FROM ColumnaProyecto c WHERE c.orden = :orden")})
public class ColumnaProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_columna_proyecto", nullable = false)
    private Integer idColumnaProyecto;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden", nullable = false)
    private int orden;
    
    @JoinColumn(name = "columna_fk", referencedColumnName = "id_columna", nullable = false)
    @ManyToOne(optional = false)
    private Columna columnaFk;
    
    @JoinColumn(name = "proyecto_fk", referencedColumnName = "id_proyecto", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto proyectoFk;

    public ColumnaProyecto() {
    }

    public ColumnaProyecto(Integer idColumnaProyecto) {
        this.idColumnaProyecto = idColumnaProyecto;
    }

    public ColumnaProyecto(Integer idColumnaProyecto, String descripcion, int orden) {
        this.idColumnaProyecto = idColumnaProyecto;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public Integer getIdColumnaProyecto() {
        return idColumnaProyecto;
    }

    public void setIdColumnaProyecto(Integer idColumnaProyecto) {
        this.idColumnaProyecto = idColumnaProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @XmlTransient
    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    public Columna getColumnaFk() {
        return columnaFk;
    }

    public void setColumnaFk(Columna columnaFk) {
        this.columnaFk = columnaFk;
    }

    public Proyecto getProyectoFk() {
        return proyectoFk;
    }

    public void setProyectoFk(Proyecto proyectoFk) {
        this.proyectoFk = proyectoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColumnaProyecto != null ? idColumnaProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColumnaProyecto)) {
            return false;
        }
        ColumnaProyecto other = (ColumnaProyecto) object;
        if ((this.idColumnaProyecto == null && other.idColumnaProyecto != null) || (this.idColumnaProyecto != null && !this.idColumnaProyecto.equals(other.idColumnaProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.admin.repo.entities.ColumnaProyecto[ idColumnaProyecto=" + idColumnaProyecto + " ]";
    }
    
}
