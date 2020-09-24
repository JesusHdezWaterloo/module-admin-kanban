package com.jhw.gestion.modules.admin.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.admin.core.domain.*;
import java.util.List;

public interface TareaRepo extends CRUDRepository<TareaDomain> {

    public List<TareaDomain> findByColumnaProyecto(ProyectoDomain proy, ColumnaDomain col);

}
