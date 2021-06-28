/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.kanban.core.domain;

import com.root101.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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

    public String abreviatura() {
        int mid = 3;
        int l = nombrePrioridad.length();
        if (l <= mid + 1) {
            return nombrePrioridad;
        } else {
            String[] spl = nombrePrioridad.split(" ");
            if (spl.length > 1) {
                return spl[1].substring(0, Math.min(mid, l)) + ".";
            }
            return nombrePrioridad.substring(0, Math.min(mid, l)) + ".";
        }
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
