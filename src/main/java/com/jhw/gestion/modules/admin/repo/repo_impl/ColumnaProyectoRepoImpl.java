package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.repo.entities.*;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class ColumnaProyectoRepoImpl extends JPACleanCRUDRepo<ColumnaProyectoDomain, ColumnaProyecto> implements ColumnaProyectoRepo {

    public ColumnaProyectoRepoImpl() {
        super(ResourcesKanban.EMF, ColumnaProyectoDomain.class, ColumnaProyecto.class);
    }

}
