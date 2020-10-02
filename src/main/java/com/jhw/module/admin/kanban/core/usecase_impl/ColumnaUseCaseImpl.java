package com.jhw.module.admin.kanban.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ColumnaDomain;
import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.repo_def.ColumnaRepo;
import com.jhw.module.admin.kanban.core.usecase_def.ColumnaUseCase;

public class ColumnaUseCaseImpl extends DefaultCRUDUseCase<ColumnaDomain> implements ColumnaUseCase {

    private final ColumnaRepo repo = KanbanCoreModule.getInstance().getImplementation(ColumnaRepo.class);

    public ColumnaUseCaseImpl() {
        super.setRepo(repo);
    }

}
