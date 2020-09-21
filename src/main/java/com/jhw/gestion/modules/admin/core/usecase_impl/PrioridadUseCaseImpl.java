package com.jhw.gestion.modules.admin.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.core.repo_def.*;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import java.util.ArrayList;
import java.util.List;

public class PrioridadUseCaseImpl extends DefaultCRUDUseCase<PrioridadDomain> implements PrioridadUseCase {

    private final PrioridadRepo repo = KanbanCoreModule.getInstance().getImplementation(PrioridadRepo.class);

    public PrioridadUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<PrioridadDomain> findAll(String searchText) throws Exception {
        List<PrioridadDomain> all = findAll();
        List<PrioridadDomain> filter = new ArrayList<>();
        for (PrioridadDomain p : all) {
            if (p.test(searchText)) {
                filter.add(p);
            }
        }
        return filter;
    }

}
