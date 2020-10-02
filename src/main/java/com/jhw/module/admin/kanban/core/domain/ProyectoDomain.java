/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.core.domain;

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
@SortBy(priority = {"prioridad"}, order = SortBy.DESCENDING)
@SortBy(priority = {"nombreProyecto"})
public class ProyectoDomain extends EntityDomainObjectValidated {

    private Integer idProyecto;

    @NotEmpty(message = "#msg.module.admin.validation.proyecto_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.proyecto_nombre_largo#")
    private String nombreProyecto;

    @NotNull(message = "#msg.module.admin.validation.proyecto_fecha_null#")
    private Date fechaInicio;

    private boolean kanban;

    private int prioridad;

    @Size(max = 495, message = "#msg.module.admin.validation.proyecto_url_local_largo#")
    private String urlLocal;

    @Size(max = 495, message = "#msg.module.admin.validation.proyecto_url_repo_online_largo#")
    private String urlRepoOnline;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public ProyectoDomain() {
    }

    public ProyectoDomain(String nombreProyecto, Date fechaInicio, boolean kanban, int prioridad, String urlLocal, String urlRepoOnline, String descripcion) {
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.kanban = kanban;
        this.prioridad = prioridad;
        this.urlLocal = urlLocal;
        this.urlRepoOnline = urlRepoOnline;
        this.descripcion = descripcion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public boolean isKanban() {
        return kanban;
    }

    public void setKanban(boolean kanban) {
        this.kanban = kanban;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getUrlLocal() {
        return urlLocal;
    }

    public void setUrlLocal(String urlLocal) {
        this.urlLocal = urlLocal;
    }

    public String getUrlRepoOnline() {
        return urlRepoOnline;
    }

    public void setUrlRepoOnline(String urlRepoOnline) {
        this.urlRepoOnline = urlRepoOnline;
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
