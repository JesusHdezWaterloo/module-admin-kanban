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
package com.root101.module.admin.kanban.rest;

import static com.root101.module.admin.kanban.rest.ModuleAdminKanbanRESTConstants.*;
import com.root101.module.admin.kanban.core.domain.*;
import com.root101.module.admin.kanban.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@RestController
@RequestMapping(value = TAREA_GENERAL_PATH)
public class TareaRESTService extends RESTServiceTemplate<TareaDomain> implements TareaUseCase {

    private final TareaUseCase tareaUC = A_ModuleAdminKanbanRESTConfig.tareaUC;

    public TareaRESTService() {
        setUseCase(tareaUC);
    }

    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy) throws Exception {
        return tareaUC.findByColumnaProyecto(colProy);
    }

    @GetMapping(TAREA_FIND_BY_COL_PROY_PATH)
    public List<TareaDomain> findByColumnaProyecto(@PathVariable(PROYECTO) Integer idProyecto, @PathVariable(COLUMNA) Integer idColumna) throws Exception {
        return tareaUC.findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth.from(idProyecto, idColumna));
    }

    @Override
    @PostMapping(TAREA_MOVE_PATH)
    public TareaDomain move(@RequestBody MoveTarea move) throws Exception {
        return tareaUC.move(move);
    }

}
