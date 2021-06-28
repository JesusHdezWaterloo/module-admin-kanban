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

import com.root101.clean.core.utils.SortBy;
import com.root101.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@SortBy(priority = {"posicion"})
public class ColumnaDomain extends EntityDomainObjectValidated {

    private Integer idColumna;

    @NotEmpty(message = "#msg.module.admin.validation.columna_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.columna_nombre_largo#")
    private String nombreColumna;

    private int posicion;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public ColumnaDomain() {
    }

    public ColumnaDomain(Integer idColumna) {
        this.idColumna = idColumna;
    }

    public ColumnaDomain(String nombreColumna, int posicion, String descripcion) {
        this.nombreColumna = nombreColumna;
        this.posicion = posicion;
        this.descripcion = descripcion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
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
