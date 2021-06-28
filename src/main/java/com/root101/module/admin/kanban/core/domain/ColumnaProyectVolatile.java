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

import com.root101.clean.core.domain.VolatileDomainObject;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ColumnaProyectVolatile extends VolatileDomainObject {

    public static ColumnaProyectVolatile from(ProyectoDomain proyecto, ColumnaDomain columna) {
        return new ColumnaProyectVolatile(proyecto, columna);
    }

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

    public LightWeigth lightweigth() {
        return LightWeigth.from(this);
    }

    public static class LightWeigth {

        public static LightWeigth from(ProyectoDomain proyecto, ColumnaDomain columna) {
            return new LightWeigth(proyecto.getIdProyecto(), columna.getIdColumna());
        }

        public static LightWeigth from(ColumnaProyectVolatile colProy) {
            return new LightWeigth(colProy.getProyecto().getIdProyecto(), colProy.getColumna().getIdColumna());
        }

        public static LightWeigth from(Integer idProyecto, Integer idColumna) {
            return new LightWeigth(idProyecto, idColumna);
        }

        public final Integer idProyecto;
        public final Integer idColumna;

        public LightWeigth(Integer idProyecto, Integer idColumna) {
            this.idProyecto = idProyecto;
            this.idColumna = idColumna;
        }

    }
}
