package com.jhw.gestion.modules.admin.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.admin.core.domain.*;
import java.util.List;

public interface ColumnaProyectoUseCase extends CRUDUseCase<ColumnaProyectoDomain> {

    public List<ColumnaProyectoDomain> findByProyecto(ProyectoDomain proyecto) throws Exception;

}
