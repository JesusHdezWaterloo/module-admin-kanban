/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreColumna"})
public class ColumnaDomain extends EntityDomainObjectValidated {

    private Integer idColumna;

    @NotEmpty(message = "#msg.module.admin.validation.columna_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.columna_nombre_largo#")
    private String nombreColumna;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public ColumnaDomain() {
    }

    public ColumnaDomain(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public ColumnaDomain(String nombreColumna, String descripcion) {
        this.nombreColumna = nombreColumna;
        this.descripcion = descripcion;
    }

    public ColumnaDomain(Integer idColumna, String nombreColumna, String descripcion) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColumna != null ? idColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColumnaDomain)) {
            return false;
        }
        ColumnaDomain other = (ColumnaDomain) object;
        if ((this.idColumna == null && other.idColumna != null) || (this.idColumna != null && !this.idColumna.equals(other.idColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreColumna;
    }

}
