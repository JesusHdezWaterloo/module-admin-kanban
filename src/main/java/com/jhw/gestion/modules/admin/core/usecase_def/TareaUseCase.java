package com.jhw.gestion.modules.admin.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import java.util.List;

public interface TareaUseCase extends CRUDUseCase<TareaDomain> {

    public List<TareaDomain> findByColumnaProyecto(ProyectoDomain proy, ColumnaDomain col) throws Exception;
}
