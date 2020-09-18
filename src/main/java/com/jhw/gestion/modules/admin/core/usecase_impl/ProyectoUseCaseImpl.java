package com.jhw.gestion.modules.admin.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;

public class ProyectoUseCaseImpl extends DefaultCRUDUseCase<ProyectoDomain> implements ProyectoUseCase {

    private final ProyectoRepo repo = KanbanCoreModule.getInstance().getImplementation(ProyectoRepo.class);

    public ProyectoUseCaseImpl() {
        super.setRepo(repo);
    }

}
