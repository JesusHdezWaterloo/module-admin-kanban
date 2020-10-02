package com.jhw.module.admin.kanban.repo.module;

import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;

/**
 * Modulo de Kanban-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new KanbanRepoInjectionConfig());

    private static KanbanRepoModule INSTANCE;

    private KanbanRepoModule() {
        ResourcesKanban.initEMF();
    }

    public static KanbanRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de nomina no se ha inicializado");
        }
        return INSTANCE;
    }

    public static KanbanRepoModule init() {
        INSTANCE = new KanbanRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Nomina Repo Module";
    }

}
