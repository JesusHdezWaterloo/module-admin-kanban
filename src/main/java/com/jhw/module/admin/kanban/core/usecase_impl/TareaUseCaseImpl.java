package com.jhw.module.admin.kanban.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ColumnaDomain;
import com.jhw.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.jhw.module.admin.kanban.core.domain.MoveTarea;
import com.jhw.module.admin.kanban.core.domain.TareaDomain;
import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.repo_def.TareaRepo;
import com.jhw.module.admin.kanban.core.usecase_def.ColumnaUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.TareaUseCase;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TareaUseCaseImpl extends DefaultCRUDUseCase<TareaDomain> implements TareaUseCase {

    private final TareaRepo repo = KanbanCoreModule.getInstance().getImplementation(TareaRepo.class);
    private final ColumnaUseCase columnaUC = KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class);

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
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy) throws Exception {
        List<TareaDomain> l = repo.findByColumnaProyecto(colProy);

        //si es de la ultima columna solo muestro el ultimo mes
        //si se quiere mostrar all comentar esta linea
        if (colProy.idColumna.equals(columnaUC.findLast().getIdColumna())) {
            LocalDate mesPasado = LocalDate.from(YearMonth.now().minusMonths(1));
            return l.stream().filter(
                    (TareaDomain t) -> t.getLastChange().isAfter(mesPasado)
            ).sorted().collect(Collectors.toList());
        } else {
            Collections.sort(l);
        }

        return l;
    }

    @Override
    public TareaDomain create(TareaDomain newObject) throws Exception {
        newObject.setLastChange(LocalDate.now());
        return super.create(newObject);
    }

    @Override
    public TareaDomain edit(TareaDomain objectToUpdate) throws Exception {
        TareaDomain tarea = findBy(objectToUpdate.getIdTarea());
        if (!tarea.getProyectoFk().equals(objectToUpdate.getProyectoFk())) {
            throw new RuntimeException("No se puede mover una tarea de proyecto. Bórrela y creela de nuevo");
        }
        objectToUpdate.setLastChange(LocalDate.now());
        return super.edit(objectToUpdate);
    }

    @Override
    public TareaDomain move(MoveTarea move) throws Exception {
        TareaDomain tarea = findBy(move.getIdTarea());
        ColumnaDomain col = columnaUC.findBy(move.getIdColumna());
        tarea.setColumnaFk(col);

        return this.edit(tarea);
    }

}
