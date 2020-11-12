/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.rest;

import static com.jhw.module.admin.kanban.core.ModuleAdminKanbanConstants.*;
import com.jhw.module.admin.kanban.core.domain.*;
import com.jhw.module.admin.kanban.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = TAREA_GENERAL_PATH)
public class TareaRESTService extends RESTServiceTemplate<TareaDomain> implements TareaUseCase {

    private final TareaUseCase tareaUC = A_ModuleAdminKanban.tareaUC;

    public TareaRESTService() {
        setUseCase(tareaUC);
    }

    @Override
    @GetMapping(TAREA_FIND_BY_COL_PROY_PATH)
    public List<TareaDomain> findByColumnaProyecto(@PathVariable(COL_PROY) ColumnaProyectVolatile colProy) throws Exception {
        return tareaUC.findByColumnaProyecto(colProy);
    }

    @Override
    @PostMapping(TAREA_MOVE_PATH)
    public TareaDomain move(@RequestBody MoveTarea move) throws Exception {
        return tareaUC.move(move);
    }

}
