package com.jhw.gestion.modules.admin.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import java.util.ArrayList;
import java.util.List;

public class ColumnaUseCaseImpl extends DefaultCRUDUseCase<ColumnaDomain> implements ColumnaUseCase {

    private final ColumnaRepo repo = KanbanCoreModule.getInstance().getImplementation(ColumnaRepo.class);

    public ColumnaUseCaseImpl() {
        super.setRepo(repo);
    }

    //no se usa
    @Override
    public List<ColumnaDomain> findByProyecto(ProyectoDomain proyecto) throws Exception{
        List<ColumnaProyectoDomain> rel = KanbanCoreModule.getInstance().getImplementation(ColumnaProyectoUseCase.class).findByProyecto(proyecto);
        List<ColumnaDomain> l = new ArrayList<>(rel.size());
        for (ColumnaProyectoDomain colProyDomain : rel) {
            l.add(colProyDomain.getColumnaFk());
        }
        return l;
    }

}
