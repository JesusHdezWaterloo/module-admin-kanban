package com.jhw.gestion.modules.admin.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.gestion.modules.admin.core.module.KanbanCoreModule;
import com.jhw.gestion.modules.admin.repo.module.KanbanRepoModule;
import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.gestion.modules.admin.service.ResourceServiceImplementation;
import com.jhw.gestion.modules.admin.ui.contrato_empleado.ContratoEmpleadoDetailView;
import com.jhw.gestion.modules.admin.ui.empleado.EmpleadoMainPanel;
import com.jhw.gestion.modules.admin.ui.pago_salario.PagoSalarioDetailView;
import com.jhw.gestion.modules.admin.ui.tipo_salario.TipoSalarioDetailView;
import com.jhw.mysql.services.MySQLHandler;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class NominaSwingModule extends DefaultAbstractSwingMainModule {

    private final NominaModuleNavigator navigator = new NominaModuleNavigator();

    public final static ContratoTrabajadorUseCase contratoTrabajadorUC;
    public final static EmpleadoUseCase empleadoUC;
    public final static PuestoTrabajoUseCase puestoTrabajoUC;
    public final static TipoSalarioUseCase tipoSalarioUC;
    public final static PagoSalarioUseCase pagoSalarioUC;

    static {
        KanbanCoreModule.init(KanbanRepoModule.init());

        contratoTrabajadorUC = KanbanCoreModule.getInstance().getImplementation(ContratoTrabajadorUseCase.class);
        empleadoUC = KanbanCoreModule.getInstance().getImplementation(EmpleadoUseCase.class);
        puestoTrabajoUC = KanbanCoreModule.getInstance().getImplementation(PuestoTrabajoUseCase.class);
        tipoSalarioUC = KanbanCoreModule.getInstance().getImplementation(TipoSalarioUseCase.class);
        pagoSalarioUC = KanbanCoreModule.getInstance().getImplementation(PagoSalarioUseCase.class);

        ResourceServiceImplementation.init();
    }

    private NominaSwingModule() {
    }

    public static NominaSwingModule init() {
        System.out.println("Iniciando 'Nomina'");
        return new NominaSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        CollapseMenu menu = new CollapseMenu(NominaModuleNavigator.ICON_NOMINA, NominaModuleNavigator.NOMINA);
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);

        dash.addView(NominaModuleNavigator.NAV_CONTRATOS, new ContratoEmpleadoDetailView());
        menu.addMenuItem(new AbstractAction(NominaModuleNavigator.CONTRATOS, NominaModuleNavigator.ICON_CONTRATOS) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(NominaModuleNavigator.NAV_CONTRATOS);
            }
        });

        dash.addView(NominaModuleNavigator.NAV_EMPLEADOS, new EmpleadoMainPanel());
        menu.addMenuItem(new AbstractAction(NominaModuleNavigator.EMPLEADOS, NominaModuleNavigator.ICON_EMPLEADOS) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(NominaModuleNavigator.NAV_EMPLEADOS);
            }
        });

        dash.addView(NominaModuleNavigator.NAV_SALARIOS, new PagoSalarioDetailView());
        menu.addMenuItem(new AbstractAction(NominaModuleNavigator.SALARIOS, NominaModuleNavigator.ICON_SALARIOS) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(NominaModuleNavigator.NAV_SALARIOS);
            }
        });

        dash.addView(NominaModuleNavigator.NAV_TIPOS_SALARIOS, new TipoSalarioDetailView());
        menu.addMenuItem(new AbstractAction(NominaModuleNavigator.TIPOS_SALARIOS, NominaModuleNavigator.ICON_TIPO_SALARIO) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(NominaModuleNavigator.NAV_TIPOS_SALARIOS);
            }
        });

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
