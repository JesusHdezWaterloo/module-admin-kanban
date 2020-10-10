package com.jhw.module.admin.kanban.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.jhw.module.admin.kanban.core.domain.TareaDomain;
import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.repo_def.TareaRepo;
import com.jhw.module.admin.kanban.core.usecase_def.ColumnaUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.TareaUseCase;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TareaUseCaseImpl extends DefaultCRUDUseCase<TareaDomain> implements TareaUseCase {

    private final TareaRepo repo = KanbanCoreModule.getInstance().getImplementation(TareaRepo.class);

    public TareaUseCaseImpl() {
        super.setRepo(repo);
    }

    /**
     * Este es el metodo con el que se llenan las tareas de las columnas del
     * kanban
     *
     * @param colProy
     * @return
     * @throws Exception
     */
    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile colProy) throws Exception {
        List<TareaDomain> l = repo.findByColumnaProyecto(colProy);
        //si es de la ultima columna solo muestro el ultimo mes
        if (colProy.getColumna().equals(KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class).findLast())) {
            Date lastMonth = new Date();
            lastMonth.setMonth(lastMonth.getMonth() - 1);

            return l.stream().filter(
                    (TareaDomain t) -> t.getLastChange().after(lastMonth)
            ).sorted().collect(Collectors.toList());
        } else {
            Collections.sort(l);
        }
        return l;
    }

    @Override
    public TareaDomain create(TareaDomain newObject) throws Exception {
        newObject.setLastChange(new Date());
        return super.create(newObject);
    }

    @Override
    public TareaDomain edit(TareaDomain objectToUpdate) throws Exception {
        TareaDomain tarea = findBy(objectToUpdate.getIdTarea());
        if (!tarea.getProyectoFk().equals(objectToUpdate.getProyectoFk())) {
            throw new RuntimeException("No se puede mover una tarea de proyecto. Bórrela y creela de nuevo");
        }
        objectToUpdate.setLastChange(new Date());
        return super.edit(objectToUpdate);
    }

}
