package com.jhw.module.admin.kanban.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.jhw.module.admin.kanban.core.domain.TareaDomain;
import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.repo_def.TareaRepo;
import com.jhw.module.admin.kanban.core.usecase_def.TareaUseCase;
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
