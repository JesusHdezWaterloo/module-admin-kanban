package com.jhw.module.admin.kanban.repo.repo_impl;

import com.jhw.module.admin.kanban.core.domain.ProyectoDomain;
import com.jhw.module.admin.kanban.core.repo_def.ProyectoRepo;
import com.jhw.module.admin.kanban.repo.entities.Proyecto;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class ProyectoRepoImpl extends JPACleanCRUDRepo<ProyectoDomain, Proyecto> implements ProyectoRepo {

    public ProyectoRepoImpl() {
        super(ResourcesKanban.EMF, ProyectoDomain.class, Proyecto.class);
    }

}
