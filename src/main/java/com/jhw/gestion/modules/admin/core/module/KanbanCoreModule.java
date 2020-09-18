package com.jhw.gestion.modules.admin.core.module;

import com.clean.core.app.modules.AbstractModule;
import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de Kanban-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new KanbanCoreInjectionConfig());

    private static KanbanCoreModule INSTANCE;

    public static KanbanCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Kanban no se ha inicializado");
        }
        return INSTANCE;
    }

    public static KanbanCoreModule init(AbstractModule repoModule) {
        INSTANCE = new KanbanCoreModule();
        INSTANCE.registerModule(repoModule);
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Kanban Core Module";
    }

}
