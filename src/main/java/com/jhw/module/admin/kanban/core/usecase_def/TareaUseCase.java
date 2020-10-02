package com.jhw.module.admin.kanban.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.jhw.module.admin.kanban.core.domain.TareaDomain;
import java.util.List;

public interface TareaUseCase extends CRUDUseCase<TareaDomain> {

    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile colProy) throws Exception;
}
