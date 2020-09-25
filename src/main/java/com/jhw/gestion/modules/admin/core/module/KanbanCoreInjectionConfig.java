package com.jhw.gestion.modules.admin.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.core.usecase_impl.*;

/**
 * Configuracion del injection del modulo de Kanban-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ColumnaUseCase.class).to(ColumnaUseCaseImpl.class).in(Singleton.class);
        bind(PrioridadUseCase.class).to(PrioridadUseCaseImpl.class).in(Singleton.class);
        bind(ProyectoUseCase.class).to(ProyectoUseCaseImpl.class).in(Singleton.class);
        bind(TareaUseCase.class).to(TareaUseCaseImpl.class).in(Singleton.class);
    }

}
