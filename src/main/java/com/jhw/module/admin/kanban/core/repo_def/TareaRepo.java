package com.jhw.module.admin.kanban.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.jhw.module.admin.kanban.core.domain.TareaDomain;
import java.util.List;

public interface TareaRepo extends CRUDRepository<TareaDomain> {

    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy);

}
