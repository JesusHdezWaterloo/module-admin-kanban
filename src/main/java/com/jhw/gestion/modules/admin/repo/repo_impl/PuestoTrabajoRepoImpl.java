package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class PuestoTrabajoRepoImpl extends JPACleanCRUDRepo<PuestoTrabajoDomain, PuestoTrabajo> implements PuestoTrabajoRepo {

    public PuestoTrabajoRepoImpl() {
        super(ResourcesKanban.EMF, PuestoTrabajoDomain.class, PuestoTrabajo.class);
    }

}
