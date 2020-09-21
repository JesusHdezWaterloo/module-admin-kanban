package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.repo.entities.*;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class PrioridadRepoImpl extends JPACleanCRUDRepo<PrioridadDomain, Prioridad> implements PrioridadRepo {

    public PrioridadRepoImpl() {
        super(ResourcesKanban.EMF, PrioridadDomain.class, Prioridad.class);
    }

}
