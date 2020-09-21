package com.jhw.gestion.modules.admin.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.admin.core.domain.*;
import java.util.List;

public interface ColumnaProyectoRepo extends CRUDRepository<ColumnaProyectoDomain> {

    public List<ColumnaProyectoDomain> findByProyecto(ProyectoDomain proyecto) throws Exception;

}
