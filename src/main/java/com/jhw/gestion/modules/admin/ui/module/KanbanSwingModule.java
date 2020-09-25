package com.jhw.gestion.modules.admin.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import com.jhw.gestion.modules.admin.core.usecase_def.*;
import com.jhw.gestion.modules.admin.repo.module.KanbanRepoModule;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.gestion.modules.admin.service.ResourceServiceImplementation;
import com.jhw.gestion.modules.admin.ui.columna.ColumnaDetailView;
import com.jhw.gestion.modules.admin.ui.prioridad.PrioridadDetailMainPanel;
import com.jhw.gestion.modules.admin.ui.proyecto.ProyectoDetailView;
import com.jhw.mysql.services.MySQLHandler;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.models.utils.UpdateListener;
import com.jhw.utils.interfaces.Update;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class KanbanSwingModule extends DefaultAbstractSwingMainModule implements Update {

    private final UpdateListener updList;
    private final CollapseMenu menu = new CollapseMenu(KanbanModuleNavigator.ICON_KANBAN, KanbanModuleNavigator.KANBAN);
    private DashBoardSimple dash;
    private AbstractSwingApplication app;

    private final KanbanModuleNavigator navigator = new KanbanModuleNavigator();

    public final static ColumnaUseCase columnaUC;
    public final static PrioridadUseCase prioridadUC;
    public final static ProyectoUseCase proyectoUC;
    public final static TareaUseCase tareaUC;

    static {
        KanbanCoreModule.init(KanbanRepoModule.init());

        columnaUC = KanbanCoreModule.getInstance().getImplementation(ColumnaUseCase.class);
        prioridadUC = KanbanCoreModule.getInstance().getImplementation(PrioridadUseCase.class);
        proyectoUC = KanbanCoreModule.getInstance().getImplementation(ProyectoUseCase.class);
        tareaUC = KanbanCoreModule.getInstance().getImplementation(TareaUseCase.class);


        ResourceServiceImplementation.init();
    }

    private KanbanSwingModule() {
        updList = new UpdateListener(this);
        KanbanSwingModule.proyectoUC.addPropertyChangeListener(updList);
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
        this.app = app;
        this.dash = app.rootView().dashboard();
        this.dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);
        update();
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

    @Override
    public void closeModule() {
        MySQLHandler.save(ResourcesKanban.SCHEMA);
    }

    @Override
    public void update() {
        menu.clear();//limpia el menu
        dash.removeGroupView(KanbanModuleNavigator.GROUP);//limpia las vistas
        
        //agrega todo lo demas
        for (KanbanProyectCreator c : KanbanProyectCreator.createKanbansProjects()) {
            dash.addView(c.nav, c.view);
            menu.addMenuItem(new AbstractAction(c.name, c.icon) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    app.navigateTo(c.nav);
                }
            });
        }

        dash.addView(KanbanModuleNavigator.NAV_PROYECTO, new ProyectoDetailView());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.PROYECTO, KanbanModuleNavigator.ICON_PROYECTO) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_PROYECTO);
            }
        });

        dash.addView(KanbanModuleNavigator.NAV_COLUMNA, new ColumnaDetailView());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.COLUMNA, KanbanModuleNavigator.ICON_COLUMNA) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_COLUMNA);
            }
        });

        dash.addView(KanbanModuleNavigator.NAV_PRIORIDAD, new PrioridadDetailMainPanel());
        menu.addMenuItem(new AbstractAction(KanbanModuleNavigator.PRIORIDAD, KanbanModuleNavigator.ICON_PRIORIDAD) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(KanbanModuleNavigator.NAV_PRIORIDAD);
            }
        });
        //repinta el dashboard
        dash.format();
    }
}
