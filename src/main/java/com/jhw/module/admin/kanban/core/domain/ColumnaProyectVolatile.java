/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.core.domain;

import com.clean.core.domain.VolatileDomainObject;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ColumnaProyectVolatile extends VolatileDomainObject {

    private final ProyectoDomain proyecto;
    private final ColumnaDomain columna;

    public ColumnaProyectVolatile(ProyectoDomain proyecto, ColumnaDomain columna) {
        this.proyecto = proyecto;
        this.columna = columna;
    }

    public ProyectoDomain getProyecto() {
        return proyecto;
    }

    public ColumnaDomain getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "ColumnaProyect{" + "proyecto=" + proyecto + ", columna=" + columna + '}';
    }

}
