/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ColumnaProyectoDomain extends EntityDomainObjectValidated {

    private Integer idColumnaProyecto;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    private int orden;

    @NotNull(message = "#msg.module.admin.validation.columna_proyecto_columna_null#")
    private ColumnaDomain columnaFk;

    @NotNull(message = "#msg.module.admin.validation.columna_proyecto_proyecto_null#")
    private ProyectoDomain proyectoFk;

    public ColumnaProyectoDomain() {
    }

    public ColumnaProyectoDomain(Integer idColumnaProyecto) {
        this.idColumnaProyecto = idColumnaProyecto;
    }

    public ColumnaProyectoDomain(Integer idColumnaProyecto, String descripcion, int orden) {
        this.idColumnaProyecto = idColumnaProyecto;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public ColumnaProyectoDomain(String descripcion, int orden, ColumnaDomain columnaFk, ProyectoDomain proyectoFk) {
        this.descripcion = descripcion;
        this.orden = orden;
        this.columnaFk = columnaFk;
        this.proyectoFk = proyectoFk;
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

    public ColumnaDomain getColumnaFk() {
        return columnaFk;
    }

    public void setColumnaFk(ColumnaDomain columnaFk) {
        this.columnaFk = columnaFk;
    }

    public ProyectoDomain getProyectoFk() {
        return proyectoFk;
    }

    public void setProyectoFk(ProyectoDomain proyectoFk) {
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
        if (!(object instanceof ColumnaProyectoDomain)) {
            return false;
        }
        ColumnaProyectoDomain other = (ColumnaProyectoDomain) object;
        if ((this.idColumnaProyecto == null && other.idColumnaProyecto != null) || (this.idColumnaProyecto != null && !this.idColumnaProyecto.equals(other.idColumnaProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return columnaFk.getNombreColumna() + " de " + proyectoFk.getNombreProyecto();
    }

}
