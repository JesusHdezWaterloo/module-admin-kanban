package com.jhw.gestion.modules.admin.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import java.util.List;

public class ColumnaProyectoUseCaseImpl extends DefaultCRUDUseCase<ColumnaProyectoDomain> implements ColumnaProyectoUseCase {

    private final ColumnaProyectoRepo repo = KanbanCoreModule.getInstance().getImplementation(ColumnaProyectoRepo.class);

    public ColumnaProyectoUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<ColumnaProyectoDomain> findByProyecto(ProyectoDomain proyecto) throws Exception {
        return repo.findByProyecto(proyecto);
    }

}
