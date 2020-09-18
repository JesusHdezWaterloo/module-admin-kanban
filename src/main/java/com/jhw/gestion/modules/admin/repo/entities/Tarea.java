/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.repo.entities;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "tarea", schema = ResourcesKanban.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo_tarea"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdTarea", query = "SELECT t FROM Tarea t WHERE t.idTarea = :idTarea"),
    @NamedQuery(name = "Tarea.findByNombreTarea", query = "SELECT t FROM Tarea t WHERE t.nombreTarea = :nombreTarea"),
    @NamedQuery(name = "Tarea.findByCodigoTarea", query = "SELECT t FROM Tarea t WHERE t.codigoTarea = :codigoTarea")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarea", nullable = false)
    private Integer idTarea;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tarea", nullable = false, length = 100)
    private String nombreTarea;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 10)
    @Column(name = "codigo_tarea", nullable = false, length = 10)
    private String codigoTarea;
    
    @JoinColumn(name = "col_proy_fk", referencedColumnName = "id_columna_proyecto", nullable = false)
    @ManyToOne(optional = false)
    private ColumnaProyecto colProyFk;
    
    @JoinColumn(name = "prioridad_fk", referencedColumnName = "id_prioridad", nullable = false)
    @ManyToOne(optional = false)
    private Prioridad prioridadFk;

    public Tarea() {
    }

    public Tarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Tarea(Integer idTarea, String nombreTarea, String codigoTarea) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.codigoTarea = codigoTarea;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(String codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public ColumnaProyecto getColProyFk() {
        return colProyFk;
    }

    public void setColProyFk(ColumnaProyecto colProyFk) {
        this.colProyFk = colProyFk;
    }

    public Prioridad getPrioridadFk() {
        return prioridadFk;
    }

    public void setPrioridadFk(Prioridad prioridadFk) {
        this.prioridadFk = prioridadFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.admin.repo.entities.Tarea[ idTarea=" + idTarea + " ]";
    }
    
}
