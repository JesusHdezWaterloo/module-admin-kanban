/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.rest;

import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.usecase_def.*;
import com.jhw.module.admin.kanban.repo.module.KanbanRepoModule;
import com.jhw.module.admin.kanban.service.ResourceServiceImplementation;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component
public class A_ModuleAdminKanban {

    public static final String BASE_PACKAGE = "com.jhw.module.admin.kanban";

    public final static ColumnaUseCase columnsUC;
    public final static PrioridadUseCase prioridadUC;
    public final static ProyectoUseCase proyectoUC;
    public final static TareaUseCase tareaUC;

    static {
        ResourceServiceImplementation.init();
        KanbanCoreModule.init(KanbanRepoModule.init());

        columnsUC = KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class);
        prioridadUC = KanbanCoreModule.getInstance().getImplementation(PrioridadUseCase.class);
        proyectoUC = KanbanCoreModule.getInstance().getImplementation(ProyectoUseCase.class);
        tareaUC = KanbanCoreModule.getInstance().getImplementation(TareaUseCase.class);
        
    }
}
