package com.jhw.module.admin.kanban.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.PrioridadDomain;
import java.util.List;

public interface PrioridadUseCase extends CRUDUseCase<PrioridadDomain> {

    public List<PrioridadDomain> findAll(String searchText) throws Exception;
}
