package com.jhw.module.admin.kanban.repo.repo_impl;

import com.jhw.module.admin.kanban.core.domain.PrioridadDomain;
import com.jhw.module.admin.kanban.core.repo_def.PrioridadRepo;
import com.jhw.module.admin.kanban.repo.entities.Prioridad;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class PrioridadRepoImpl extends JPACleanCRUDRepo<PrioridadDomain, Prioridad> implements PrioridadRepo {

    public PrioridadRepoImpl() {
        super(ResourcesKanban.EMF, PrioridadDomain.class, Prioridad.class);
    }

}
