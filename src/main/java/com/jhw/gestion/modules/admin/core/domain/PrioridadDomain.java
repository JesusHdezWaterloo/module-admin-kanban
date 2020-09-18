/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
//ordena por comparable
public class PrioridadDomain extends EntityDomainObjectValidated implements Comparable<PrioridadDomain> {

    private Integer idPrioridad;

    @NotEmpty(message = "#msg.module.admin.validation.prioridad_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.prioridad_nombre_largo#")
    private String nombrePrioridad;

    private int valorComparable;

    private int color;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public PrioridadDomain() {
    }

    public PrioridadDomain(String nombrePrioridad, int valorComparable, int color, String descripcion) {
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
        if (!(object instanceof PrioridadDomain)) {
            return false;
        }
        PrioridadDomain other = (PrioridadDomain) object;
        if ((this.idPrioridad == null && other.idPrioridad != null) || (this.idPrioridad != null && !this.idPrioridad.equals(other.idPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePrioridad;
    }

    @Override
    public int compareTo(PrioridadDomain o) {
        return Integer.compare(this.valorComparable, o.valorComparable);
    }

}
