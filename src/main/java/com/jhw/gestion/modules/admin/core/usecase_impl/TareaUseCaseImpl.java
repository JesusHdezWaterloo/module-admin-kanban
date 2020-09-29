package com.jhw.gestion.modules.admin.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import java.util.Collections;
import java.util.List;

public class TareaUseCaseImpl extends DefaultCRUDUseCase<TareaDomain> implements TareaUseCase {

    private final TareaRepo repo = KanbanCoreModule.getInstance().getImplementation(TareaRepo.class);

    public TareaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile colProy) throws Exception {
        List<TareaDomain> l = repo.findByColumnaProyecto(colProy);
        Collections.sort(l);
        return l;
    }

    @Override
    public TareaDomain edit(TareaDomain objectToUpdate) throws Exception {
        TareaDomain tarea = findBy(objectToUpdate.getIdTarea());
        if (!tarea.getProyectoFk().equals(objectToUpdate.getProyectoFk())) {
            throw new RuntimeException("No se puede mover una tarea de proyecto. Bórrela y creela de nuevo");
        }
        return super.edit(objectToUpdate);
    }

}
