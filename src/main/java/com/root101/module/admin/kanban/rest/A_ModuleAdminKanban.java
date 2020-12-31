/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.admin.kanban.rest;

import com.root101.module.admin.kanban.core.module.KanbanCoreModule;
import com.root101.module.admin.kanban.core.usecase_def.*;
import com.root101.module.admin.kanban.repo.module.KanbanRepoModule;
import com.root101.module.admin.kanban.service.ResourceServiceServerImplementation;
import org.springframework.stereotype.Component;
import com.root101.module.admin.kanban.service.ResourceServiceImplementation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component
public class A_ModuleAdminKanban {

    public static final String BASE_PACKAGE = "com.root101.module.admin.kanban";

    public final static ColumnaUseCase columnsUC;
    public final static PrioridadUseCase prioridadUC;
    public final static ProyectoUseCase proyectoUC;
    public final static TareaUseCase tareaUC;

    static {
        ResourceServiceImplementation.init();//creo el resource general
        ResourceServiceServerImplementation.init();//creo el resource general

        KanbanCoreModule.init();

        columnsUC = KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class);
        prioridadUC = KanbanCoreModule.getInstance().getImplementation(PrioridadUseCase.class);
        proyectoUC = KanbanCoreModule.getInstance().getImplementation(ProyectoUseCase.class);
        tareaUC = KanbanCoreModule.getInstance().getImplementation(TareaUseCase.class);

    }
}
