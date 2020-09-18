package com.jhw.gestion.modules.admin.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import java.util.List;

public interface PrioridadUseCase extends CRUDUseCase<PrioridadDomain> {

    public List<PrioridadDomain> findAll(String searchText) throws Exception;
}
