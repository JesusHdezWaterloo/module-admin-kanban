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
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = KANBAN_GENERAL_PATH)
public class ColumnaRESTService extends RESTServiceTemplate<ColumnaDomain> implements ColumnaUseCase {

    private final ColumnaUseCase columnsUC = A_ModuleAdminKanban.columnsUC;

    public ColumnaRESTService() {
        setUseCase(columnsUC);
    }

    @Override
    @GetMapping(COLUMNA_FIND_FIRST_PATH)
    public ColumnaDomain findFirst() throws Exception {
        return columnsUC.findFirst();
    }

    @Override
    @GetMapping(COLUMNA_FIND_LAST_PATH)
    public ColumnaDomain findLast() throws Exception {
        return columnsUC.findLast();
    }

}
