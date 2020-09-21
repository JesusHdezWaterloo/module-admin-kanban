/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TareaDomain extends EntityDomainObjectValidated implements Comparable<TareaDomain> {

    private Integer idTarea;

    @NotEmpty(message = "#msg.module.admin.validation.tarea_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.tarea_nombre_largo#")
    private String nombreTarea;

    @NotEmpty(message = "#msg.module.admin.validation.tarea_codigo_vacio#")
    @Size(max = 10, message = "#msg.module.admin.validation.tarea_codigo_largo#")
    private String codigoTarea;

    @NotNull(message = "#msg.module.admin.validation.tarea_columna_proy_null#")
    private ColumnaProyectoDomain colProyFk;

    @NotNull(message = "#msg.module.admin.validation.tarea_prioridad_null#")
    private PrioridadDomain prioridadFk;

    public TareaDomain() {
    }

    public TareaDomain(String nombreTarea, String codigoTarea, ColumnaProyectoDomain colProyFk, PrioridadDomain prioridadFk) {
        this.nombreTarea = nombreTarea;
        this.codigoTarea = codigoTarea;
        this.colProyFk = colProyFk;
        this.prioridadFk = prioridadFk;
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

    public ColumnaProyectoDomain getColProyFk() {
        return colProyFk;
    }

    public void setColProyFk(ColumnaProyectoDomain colProyFk) {
        this.colProyFk = colProyFk;
    }

    public PrioridadDomain getPrioridadFk() {
        return prioridadFk;
    }

    public void setPrioridadFk(PrioridadDomain prioridadFk) {
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
        if (!(object instanceof TareaDomain)) {
            return false;
        }
        TareaDomain other = (TareaDomain) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoTarea + ": " + nombreTarea;
    }

    @Override
    public int compareTo(TareaDomain o) {
        int prior = this.prioridadFk.compareTo(o.prioridadFk);
        if (prior == 0) {
            return codigoTarea.compareToIgnoreCase(o.codigoTarea);
        }
        return prior;
    }

}
