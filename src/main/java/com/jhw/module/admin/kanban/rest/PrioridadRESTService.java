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
@RequestMapping(value = PRIORIDAD_GENERAL_PATH)
public class PrioridadRESTService extends RESTServiceTemplate<PrioridadDomain> implements PrioridadUseCase {

    private final PrioridadUseCase prioridadUC = A_ModuleAdminKanbanEmpresarial.prioridadUC;

    public PrioridadRESTService() {
        setUseCase(prioridadUC);
    }

    @Override
    @GetMapping(PRIORIDAD_FIND_ALL_SEARCH_PATH)
    public List<PrioridadDomain> findAll(@PathVariable(SEARCH) String searchText) throws Exception {
        return prioridadUC.findAll(searchText);
    }

}
