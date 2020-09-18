package com.jhw.gestion.modules.admin.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;

public class TareaUseCaseImpl extends DefaultCRUDUseCase<TareaDomain> implements TareaUseCase {

    private final TareaRepo repo = KanbanCoreModule.getInstance().getImplementation(TareaRepo.class);

    public TareaUseCaseImpl() {
        super.setRepo(repo);
    }

}
