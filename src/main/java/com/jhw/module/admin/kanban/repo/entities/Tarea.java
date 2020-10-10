/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.repo.entities;

import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
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
    @NamedQuery(name = "Tarea.findByCodigoTarea", query = "SELECT t FROM Tarea t WHERE t.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Tarea.findByPuntos", query = "SELECT t FROM Tarea t WHERE t.puntos = :puntos"),
    @NamedQuery(name = "Tarea.findByDescripcion", query = "SELECT t FROM Tarea t WHERE t.descripcion = :descripcion")})
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
    @Size(min = 1, max = 10)
    @Column(name = "codigo_tarea", nullable = false, length = 10)
    private String codigoTarea;

    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos", nullable = false)
    private int puntos;

    @Basic(optional = false)
    @NotNull
    @Size(max = 1000)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "prioridad_fk", referencedColumnName = "id_prioridad", nullable = false)
    @ManyToOne(optional = false)
    private Prioridad prioridadFk;

    @JoinColumn(name = "proyecto_fk", referencedColumnName = "id_proyecto", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto proyectoFk;

    @JoinColumn(name = "columna_fk", referencedColumnName = "id_columna", nullable = false)
    @ManyToOne(optional = false)
    private Columna columnaFk;

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_change", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastChange;

    public Tarea() {
    }

    public Tarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Tarea(Integer idTarea, String nombreTarea, String codigoTarea, int puntos, String descripcion, Prioridad prioridadFk, Proyecto proyectoFk, Columna columnaFk, Date lastChange) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.codigoTarea = codigoTarea;
        this.puntos = puntos;
        this.descripcion = descripcion;
        this.prioridadFk = prioridadFk;
        this.proyectoFk = proyectoFk;
        this.columnaFk = columnaFk;
        this.lastChange = lastChange;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Columna getColumnaFk() {
        return columnaFk;
    }

    public void setColumnaFk(Columna columnaFk) {
        this.columnaFk = columnaFk;
    }

    public Prioridad getPrioridadFk() {
        return prioridadFk;
    }

    public void setPrioridadFk(Prioridad prioridadFk) {
        this.prioridadFk = prioridadFk;
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
        return "testJPA.entities.kanban.Tarea[ idTarea=" + idTarea + " ]";
    }

}
