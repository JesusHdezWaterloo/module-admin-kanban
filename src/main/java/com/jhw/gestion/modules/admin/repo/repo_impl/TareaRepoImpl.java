package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.repo.entities.*;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
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
    public List<TareaDomain> findByColumnaProyecto(ProyectoDomain proy, ColumnaDomain col) {
        EntityManager em = getEntityManager();

        try {
            List<Tarea> list = em.createQuery(Tarea_findByColumnaProyecto, Tarea.class)
                    .setParameter("proyectoFk", ConverterService.convert(proy, Proyecto.class))
                    .setParameter("columnaFk", ConverterService.convert(col, Columna.class))
                    .getResultList();
            return ConverterService.convert(list, TareaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
