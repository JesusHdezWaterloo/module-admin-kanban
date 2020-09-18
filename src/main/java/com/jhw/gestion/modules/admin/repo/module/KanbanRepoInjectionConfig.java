package com.jhw.gestion.modules.admin.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Configuracion del injection del modulo de Kanban-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ContratoTrabajadorRepo.class).to(ContratoTrabajadorRepoImpl.class).in(Singleton.class);
        bind(EmpleadoRepo.class).to(EmpleadoRepoImpl.class).in(Singleton.class);
        bind(PuestoTrabajoRepo.class).to(PuestoTrabajoRepoImpl.class).in(Singleton.class);
        bind(PagoSalarioRepo.class).to(PagoSalarioRepoImpl.class).in(Singleton.class);
        bind(TipoSalarioRepo.class).to(TipoSalarioRepoImpl.class).in(Singleton.class);
    }

}
