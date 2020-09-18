package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class ContratoTrabajadorRepoImpl extends JPACleanCRUDRepo<ContratoEmpleadoDomain, ContratoEmpleado> implements ContratoTrabajadorRepo {

    public ContratoTrabajadorRepoImpl() {
        super(ResourcesKanban.EMF, ContratoEmpleadoDomain.class, ContratoEmpleado.class);
    }

}
