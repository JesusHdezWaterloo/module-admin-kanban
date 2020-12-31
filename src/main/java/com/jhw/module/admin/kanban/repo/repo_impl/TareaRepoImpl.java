package com.jhw.module.admin.kanban.repo.repo_impl;

import com.jhw.module.admin.kanban.core.domain.*;
import com.jhw.module.admin.kanban.core.repo_def.*;
import com.jhw.module.admin.kanban.repo.entities.*;
import com.jhw.module.admin.kanban.repo.module.KanbanRepoModule;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import com.root101.repo.jpa.JPACleanCRUDRepo;
import com.root101.utils.services.ConverterService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class TareaRepoImpl extends JPACleanCRUDRepo<TareaDomain, Tarea> implements TareaRepo {

    private final String Tarea_findByColumnaProyecto = "SELECT t FROM Tarea t WHERE t.proyectoFk = :proyectoFk AND t.columnaFk = :columnaFk";

    private final ColumnaRepo colRepo = KanbanRepoModule.getInstance().getImplementation(ColumnaRepo.class);
    private final ProyectoRepo proyRepo = KanbanRepoModule.getInstance().getImplementation(ProyectoRepo.class);

    public TareaRepoImpl() {
        super(ResourcesKanban.EMF, TareaDomain.class, Tarea.class);
    }

    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy) {
        EntityManager em = getEntityManager();

        try {
            Proyecto proy = ConverterService.convert(proyRepo.findBy(colProy.idProyecto), Proyecto.class);
            Columna col = ConverterService.convert(colRepo.findBy(colProy.idColumna), Columna.class);

            List<Tarea> list = em.createQuery(Tarea_findByColumnaProyecto, Tarea.class)
                    .setParameter("proyectoFk", proy)
                    .setParameter("columnaFk", col)
                    .getResultList();
            return ConverterService.convert(list, TareaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
