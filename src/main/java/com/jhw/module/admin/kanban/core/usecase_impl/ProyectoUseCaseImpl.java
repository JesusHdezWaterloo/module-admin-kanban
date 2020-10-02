package com.jhw.module.admin.kanban.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ProyectoDomain;
import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.repo_def.ProyectoRepo;
import com.jhw.module.admin.kanban.core.usecase_def.ProyectoUseCase;

public class ProyectoUseCaseImpl extends DefaultCRUDUseCase<ProyectoDomain> implements ProyectoUseCase {

    private final ProyectoRepo repo = KanbanCoreModule.getInstance().getImplementation(ProyectoRepo.class);

    public ProyectoUseCaseImpl() {
        super.setRepo(repo);
    }

}
