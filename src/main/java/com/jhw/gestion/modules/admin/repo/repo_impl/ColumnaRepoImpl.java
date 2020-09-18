package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.repo.entities.*;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class ColumnaRepoImpl extends JPACleanCRUDRepo<ColumnaDomain, Columna> implements ColumnaRepo {

    public ColumnaRepoImpl() {
        super(ResourcesKanban.EMF, ColumnaDomain.class, Columna.class);
    }

}
