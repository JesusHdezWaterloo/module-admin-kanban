package com.jhw.module.admin.kanban.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.admin.kanban.core.usecase_def.ColumnaUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.PrioridadUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.ProyectoUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.TareaUseCase;
import com.jhw.module.admin.kanban.core.usecase_impl.ColumnaUseCaseImpl;
import com.jhw.module.admin.kanban.core.usecase_impl.PrioridadUseCaseImpl;
import com.jhw.module.admin.kanban.core.usecase_impl.ProyectoUseCaseImpl;
import com.jhw.module.admin.kanban.core.usecase_impl.TareaUseCaseImpl;

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