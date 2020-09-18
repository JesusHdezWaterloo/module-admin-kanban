package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class PagoSalarioRepoImpl extends JPACleanCRUDRepo<PagoSalarioDomain, PagoSalario> implements PagoSalarioRepo {

    public PagoSalarioRepoImpl() {
        super(ResourcesKanban.EMF, PagoSalarioDomain.class, PagoSalario.class);
    }

}
