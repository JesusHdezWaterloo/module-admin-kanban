package com.jhw.module.admin.kanban.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.admin.kanban.core.domain.ProyectoDomain;

public interface ProyectoUseCase extends CRUDUseCase<ProyectoDomain> {

    /**
     * Actualiza todas las ramas contra el repo online
     *
     * @param proyecto
     * @throws Exception
     */
    public void updateRemote(ProyectoDomain proyecto) throws Exception;

    /**
     * Revisa si un proyecto tiene al menos un remote
     *
     * @param proyecto
     * @throws Exception
     */
    public boolean hasRemote(ProyectoDomain proyecto);
}
