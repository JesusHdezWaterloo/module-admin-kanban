package com.jhw.module.admin.kanban.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.clean.swing.utils.DashBoardComponent;
import com.jhw.module.admin.kanban.core.module.KanbanCoreModule;
import com.jhw.module.admin.kanban.core.usecase_def.ColumnaUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.PrioridadUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.ProyectoUseCase;
import com.jhw.module.admin.kanban.core.usecase_def.TareaUseCase;
import com.jhw.module.admin.kanban.repo.module.KanbanRepoModule;
import com.jhw.module.admin.kanban.repo.utils.ResourcesKanban;
import com.jhw.module.admin.kanban.service.ResourceServiceImplementation;
import com.jhw.module.util.mysql.services.MySQLHandler;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.models.utils.UpdateListener;
import com.jhw.utils.interfaces.Update;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

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
        for (DashBoardComponent c : navigator.createComponents()) {
            dash.addView(c.nav, c.view);
            menu.addMenuItem(c.buildAction(app));
        }

        //repinta el dashboard
        dash.format();
    }
}
