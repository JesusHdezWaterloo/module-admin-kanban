package com.root101.module.admin.kanban.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.root101.module.admin.kanban.core.repo_def.*;
import com.root101.module.admin.kanban.repo.repo_impl.*;

/**
 * Configuracion del injection del modulo de Kanban-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ColumnaRepo.class).to(ColumnaRepoImpl.class).in(Singleton.class);
        bind(PrioridadRepo.class).to(PrioridadRepoImpl.class).in(Singleton.class);
        bind(ProyectoRepo.class).to(ProyectoRepoImpl.class).in(Singleton.class);
        bind(TareaRepo.class).to(TareaRepoImpl.class).in(Singleton.class);
    }

}
