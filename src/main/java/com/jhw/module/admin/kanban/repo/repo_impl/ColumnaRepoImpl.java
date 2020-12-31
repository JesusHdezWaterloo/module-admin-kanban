package com.jhw.module.admin.kanban.repo.repo_impl;

import com.jhw.module.admin.kanban.core.domain.ColumnaDomain;
import com.jhw.module.admin.kanban.core.repo_def.ColumnaRepo;
import com.jhw.module.admin.kanban.repo.entities.Columna;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class ColumnaRepoImpl extends JPACleanCRUDRepo<ColumnaDomain, Columna> implements ColumnaRepo {

    public ColumnaRepoImpl() {
        super(ResourcesKanban.EMF, ColumnaDomain.class, Columna.class);
    }

}
