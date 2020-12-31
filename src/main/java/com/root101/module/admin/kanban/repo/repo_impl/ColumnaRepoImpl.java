package com.root101.module.admin.kanban.repo.repo_impl;

import com.root101.module.admin.kanban.core.domain.ColumnaDomain;
import com.root101.module.admin.kanban.core.repo_def.ColumnaRepo;
import com.root101.module.admin.kanban.repo.entities.Columna;
import com.root101.module.admin.kanban.repo.utils.ResourcesKanban;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class ColumnaRepoImpl extends JPACleanCRUDRepo<ColumnaDomain, Columna> implements ColumnaRepo {

    public ColumnaRepoImpl() {
        super(ResourcesKanban.EMF, ColumnaDomain.class, Columna.class);
    }

}
