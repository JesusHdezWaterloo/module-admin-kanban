package com.jhw.gestion.modules.admin.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.repo.module.KanbanRepoModule;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.gestion.modules.admin.service.ResourceServiceImplementation;
import com.jhw.mysql.services.MySQLHandler;

public class KanbanSwingModule extends DefaultAbstractSwingMainModule {

    private final KanbanModuleNavigator navigator = new KanbanModuleNavigator();

    public final static ColumnaProyectoUseCase columnaProyectoUC;
    public final static ColumnaUseCase columnaUC;
    public final static PrioridadUseCase prioridadUC;
    public final static ProyectoUseCase proyectoUC;
    public final static TareaUseCase tareaUC;

    static {
        KanbanCoreModule.init(KanbanRepoModule.init());

        columnaProyectoUC = KanbanCoreModule.getInstance().getImplementation(ColumnaProyectoUseCase.class);
        columnaUC = KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class);
        prioridadUC = KanbanCoreModule.getInstance().getImplementation(PrioridadUseCase.class);
        proyectoUC = KanbanCoreModule.getInstance().getImplementation(ProyectoUseCase.class);
        tareaUC = KanbanCoreModule.getInstance().getImplementation(TareaUseCase.class);

        ResourceServiceImplementation.init();
    }

    private KanbanSwingModule() {
    }

    public static KanbanSwingModule init() {
        System.out.println("Iniciando 'Kanban'");
        return new KanbanSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();
        /*
        CollapseMenu menu = new CollapseMenu(KanbanModuleNavigator.ICON_NOMINA, KanbanModuleNavigator.NOMINA);
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);

        dash.addView(KanbanModuleNavigator.NAV_CONTRATOS, new ContratoEmpleadoDetailView());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.CONTRATOS, KanbanModuleNavigator.ICON_CONTRATOS) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_CONTRATOS);
            }
        });

        dash.addView(KanbanModuleNavigator.NAV_EMPLEADOS, new EmpleadoMainPanel());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.EMPLEADOS, KanbanModuleNavigator.ICON_EMPLEADOS) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_EMPLEADOS);
            }
        });

        dash.addView(KanbanModuleNavigator.NAV_SALARIOS, new PagoSalarioDetailView());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.SALARIOS, KanbanModuleNavigator.ICON_SALARIOS) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_SALARIOS);
            }
        });

        dash.addView(KanbanModuleNavigator.NAV_TIPOS_SALARIOS, new TipoSalarioDetailView());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.TIPOS_SALARIOS, KanbanModuleNavigator.ICON_TIPO_SALARIO) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_TIPOS_SALARIOS);
            }
        });
         */
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

    @Override
    public void closeModule() {
        MySQLHandler.save(ResourcesKanban.SCHEMA);
    }
}
