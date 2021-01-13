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
package com.root101.module.admin.kanban.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.clean.core.utils.Licenced;
import com.root101.module.admin.kanban.core.domain.ColumnaDomain;
import com.root101.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.root101.module.admin.kanban.core.domain.MoveTarea;
import com.root101.module.admin.kanban.core.domain.TareaDomain;
import com.root101.module.admin.kanban.core.module.KanbanCoreModule;
import com.root101.module.admin.kanban.core.repo_def.TareaRepo;
import com.root101.module.admin.kanban.core.usecase_def.ColumnaUseCase;
import com.root101.module.admin.kanban.core.usecase_def.TareaUseCase;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class TareaUseCaseImpl extends DefaultCRUDUseCase<TareaDomain> implements TareaUseCase {

    private final TareaRepo repo = KanbanCoreModule.getInstance().getImplementation(TareaRepo.class);
    private final ColumnaUseCase columnaUC = KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class);

    public TareaUseCaseImpl() {
        super.setRepo(repo);
    }

    /**
     * Este es el metodo con el que se llenan las tareas de las columnas del
     * kanban
     *
     * @param colProy
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy) throws RuntimeException {
        List<TareaDomain> l = repo.findByColumnaProyecto(colProy);

        //si es de la ultima columna solo muestro el ultimo mes
        //si se quiere mostrar all comentar esta linea
        if (colProy.idColumna.equals(columnaUC.findLast().getIdColumna())) {
            LocalDate mesPasado = LocalDate.now().minusMonths(1);
            return l.stream().filter(
                    (TareaDomain t) -> t.getLastChange().isAfter(mesPasado)
            ).sorted().collect(Collectors.toList());
        } else {
            Collections.sort(l);
        }

        return l;
    }

    @Override
    @Licenced
    public TareaDomain create(TareaDomain newObject) throws RuntimeException {
        newObject.setLastChange(LocalDate.now());
        return super.create(newObject);
    }

    @Override
    @Licenced
    public TareaDomain edit(TareaDomain objectToUpdate) throws RuntimeException {
        TareaDomain tarea = findBy(objectToUpdate.getIdTarea());
        if (!tarea.getProyectoFk().equals(objectToUpdate.getProyectoFk())) {
            throw new RuntimeException("No se puede mover una tarea de proyecto. Bórrela y creela de nuevo");
        }
        objectToUpdate.setLastChange(LocalDate.now());
        return super.edit(objectToUpdate);
    }

    @Override
    public TareaDomain move(MoveTarea move) throws RuntimeException {
        TareaDomain tarea = findBy(move.getIdTarea());
        ColumnaDomain col = columnaUC.findBy(move.getIdColumna());
        tarea.setColumnaFk(col);

        return this.edit(tarea);
    }

}
