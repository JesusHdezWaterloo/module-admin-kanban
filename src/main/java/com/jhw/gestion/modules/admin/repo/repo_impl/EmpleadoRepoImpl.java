package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class EmpleadoRepoImpl extends JPACleanCRUDRepo<EmpleadoDomain, Empleado> implements EmpleadoRepo {

    public EmpleadoRepoImpl() {
        super(ResourcesKanban.EMF, EmpleadoDomain.class, Empleado.class);
    }

}
