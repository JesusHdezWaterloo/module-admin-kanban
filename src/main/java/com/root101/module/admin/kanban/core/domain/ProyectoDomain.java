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
import java.io.File;
import java.time.LocalDate;
import java.util.StringTokenizer;
import javax.validation.constraints.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@SortBy(priority = {"prioridad"}, order = SortBy.DESCENDING)
@SortBy(priority = {"nombreProyecto"})
public class ProyectoDomain extends EntityDomainObjectValidated {

    public static final int CARPETAS_UP = 1;

    private Integer idProyecto;

    @NotEmpty(message = "#msg.module.admin.validation.proyecto_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.admin.validation.proyecto_nombre_largo#")
    private String nombreProyecto;

    @NotNull(message = "#msg.module.admin.validation.proyecto_fecha_null#")
    private LocalDate fechaInicio;

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

    public ProyectoDomain(String nombreProyecto, LocalDate fechaInicio, boolean kanban, int prioridad, String urlLocal, String urlRepoOnline, String descripcion) {
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.kanban = kanban;
        this.prioridad = prioridad;
        this.urlLocal = urlLocal;
        this.urlRepoOnline = urlRepoOnline;
        this.descripcion = descripcion;
    }

    public String urlLocalFixed() {
        try {
            File f = new File(urlLocal);
            String fix = f.getName();
            for (int i = 0; i < CARPETAS_UP; i++) {
                f = f.getParentFile();
                if (f == null) {
                    break;
                }
                fix = f.getName() + "\\" + fix;
            }
            fix = "\\...\\" + fix;
            return fix;
        } catch (Exception e) {
            return "Sin URL local";
        }
    }

    /**
     * Si los nombres son muy grandes no se ven bien en un dashboard, por lo que
     * se reducen para que quepan.
     *
     * @return
     */
    public String nameFixed() {
        String fix = "";
        StringTokenizer spl = new StringTokenizer(nombreProyecto, " ");
        int c = spl.countTokens();
        if (c <= 1) {
            return nombreProyecto;
        }
        for (int i = 0; i < c - 1; i++) {
            String pice = spl.nextToken();
            if (pice.length() <= 1) {
                fix += pice;
            } else {
                fix += (pice.charAt(0) + "").toUpperCase();
            }
            fix = fix.trim();
        }
        //pongo el ultimo token completo
        fix += spl.nextToken().trim();

        return fix;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
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
