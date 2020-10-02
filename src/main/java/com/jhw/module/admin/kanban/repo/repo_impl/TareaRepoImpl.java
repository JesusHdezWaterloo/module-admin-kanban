package com.jhw.module.admin.kanban.repo.repo_impl;

import com.jhw.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.jhw.module.admin.kanban.core.domain.TareaDomain;
import com.jhw.module.admin.kanban.core.repo_def.TareaRepo;
import com.jhw.module.admin.kanban.repo.entities.Columna;
import com.jhw.module.admin.kanban.repo.entities.Proyecto;
import com.jhw.module.admin.kanban.repo.entities.Tarea;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.utils.services.ConverterService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class TareaRepoImpl extends JPACleanCRUDRepo<TareaDomain, Tarea> implements TareaRepo {

    private final String Tarea_findByColumnaProyecto = "SELECT t FROM Tarea t WHERE t.proyectoFk = :proyectoFk AND t.columnaFk = :columnaFk";

    public TareaRepoImpl() {
        super(ResourcesKanban.EMF, TareaDomain.class, Tarea.class);
    }

    @Override
    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile colProy) {
        EntityManager em = getEntityManager();

        try {
            List<Tarea> list = em.createQuery(Tarea_findByColumnaProyecto, Tarea.class)
                    .setParameter("proyectoFk", ConverterService.convert(colProy.getProyecto(), Proyecto.class))
                    .setParameter("columnaFk", ConverterService.convert(colProy.getColumna(), Columna.class))
                    .getResultList();
            return ConverterService.convert(list, TareaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
