package com.root101.module.admin.kanban.core.repo_def;

import com.root101.clean.core.app.repo.CRUDRepository;
import com.root101.module.admin.kanban.core.domain.ColumnaProyectVolatile;
import com.root101.module.admin.kanban.core.domain.TareaDomain;
import java.util.List;

public interface TareaRepo extends CRUDRepository<TareaDomain> {

    public List<TareaDomain> findByColumnaProyecto(ColumnaProyectVolatile.LightWeigth colProy);

}
