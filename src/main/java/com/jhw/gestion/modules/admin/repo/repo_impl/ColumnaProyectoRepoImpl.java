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

public class ColumnaProyectoRepoImpl extends JPACleanCRUDRepo<ColumnaProyectoDomain, ColumnaProyecto> implements ColumnaProyectoRepo {

    private final String ColumnaProyecto_findByProyecto = "SELECT c FROM ColumnaProyecto c WHERE c.proyectoFk = :proyectoFk";

    public ColumnaProyectoRepoImpl() {
        super(ResourcesKanban.EMF, ColumnaProyectoDomain.class, ColumnaProyecto.class);
    }

    @Override
    public List<ColumnaProyectoDomain> findByProyecto(ProyectoDomain proyecto) {
        EntityManager em = getEntityManager();
        try {
            List<ColumnaProyecto> list = em.createQuery(ColumnaProyecto_findByProyecto, ColumnaProyecto.class).setParameter("proyectoFk", ConverterService.convert(proyecto, Proyecto.class)).getResultList();
            return ConverterService.convert(list, ColumnaProyectoDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
