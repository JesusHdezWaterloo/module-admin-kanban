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
package com.root101.module.admin.kanban.repo.repo_impl;

import com.root101.module.admin.kanban.core.domain.*;
import com.root101.module.admin.kanban.core.repo_def.*;
import com.root101.module.admin.kanban.repo.entities.*;
import com.root101.module.admin.kanban.repo.module.KanbanRepoModule;
import com.root101.module.admin.kanban.repo.utils.ResourcesKanban;
import com.root101.repo.jpa.JPACleanCRUDRepo;
import com.root101.utils.services.ConverterService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class TareaRepoImpl extends JPACleanCRUDRepo<TareaDomain, Tarea> implements TareaRepo {

    private final String Tarea_findByColumnaProyecto = "SELECT t FROM Tarea t WHERE t.proyectoFk.idProyecto = :idProyecto AND t.columnaFk.idColumna = :idColumna";

    public TareaRepoImpl() {
        super(ResourcesKanban.EMF, TareaDomain.class, Tarea.class);
    }

    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy) {//TODO: por que no lanzar excepcion y ya
        EntityManager em = getEntityManager();

        try {
            List<Tarea> list = em.createQuery(Tarea_findByColumnaProyecto, Tarea.class)
                    .setParameter("idProyecto", colProy.idProyecto)
                    .setParameter("idColumna", colProy.idColumna)
                    .getResultList();
            return ConverterService.convert(list, TareaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
