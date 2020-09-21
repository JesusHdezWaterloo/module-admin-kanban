/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreProyecto"})
public class ProyectoDomain extends EntityDomainObjectValidated {

    private Integer idProyecto;

    @NotEmpty(message = "#msg.module.admin.validation.proyecto_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.proyecto_nombre_largo#")
    private String nombreProyecto;

    @NotNull(message = "#msg.module.admin.validation.proyecto_fecha_null#")
    private Date fechaInicio;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public ProyectoDomain() {
    }

    public ProyectoDomain(String nombreProyecto, Date fechaInicio, String descripcion) {
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoDomain)) {
            return false;
        }
        ProyectoDomain other = (ProyectoDomain) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreProyecto;
    }

}
