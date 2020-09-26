package com.jhw.gestion.modules.admin.ui.module;

import com.clean.core.app.services.NavigationService;
import com.clean.swing.utils.DashBoardComponent;
import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.columna.ColumnaDetailView;
import com.jhw.gestion.modules.admin.ui.kanban.KanbanProyecto;
import com.jhw.gestion.modules.admin.ui.prioridad.PrioridadDetailMainPanel;
import com.jhw.gestion.modules.admin.ui.proyecto.ProyectoDetailView;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanModuleNavigator implements NavigationService {

    //test mientras tanto
    public static final DerivableIcon ICON_KANBAN_PROJECT = MaterialIcons.TEC_NB;

    public static final String GROUP = "modulos.kanaban";

    public static final String KANBAN = "Kanban";
    public static final String PROYECTO = "Proyecto";
    public static final String COLUMNA = "Columna";
    public static final String PRIORIDAD = "Prioridad";
    public static final String TAREA = "Tarea";

    public static final DerivableIcon ICON_KANBAN = MaterialIcons.GRID_ON;
    public static final DerivableIcon ICON_PROYECTO = MaterialIcons.ACCOUNT_BOX;
    public static final DerivableIcon ICON_COLUMNA = MaterialIcons.ACCOUNT_BOX;
    public static final DerivableIcon ICON_PRIORIDAD = MaterialIcons.WARNING;
    public static final DerivableIcon ICON_TAREA = MaterialIcons.HOME;

    public static final String NAV_PROYECTO = GROUP + ".proyecto";
    public static final String NAV_COLUMNA = GROUP + ".columna";
    public static final String NAV_PRIORIDAD = GROUP + ".prioridad";
    public static final String NAV_TAREA = GROUP + ".tarea";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
        }
    }

    public List<DashBoardComponent> createComponents() {
        List<DashBoardComponent> list = new ArrayList<>();
        try {
            for (ProyectoDomain proyectoDomain : KanbanSwingModule.proyectoUC.findAll()) {
                if (proyectoDomain.isKanban()) {
                    list.add(DashBoardComponent.from(
                            proyectoDomain.getNombreProyecto(),
                            ICON_KANBAN_PROJECT,
                            KanbanModuleNavigator.GROUP + "." + proyectoDomain.getNombreProyecto(),
                            KanbanProyecto.from(proyectoDomain)));
                }
            }

            list.add(DashBoardComponent.from(
                    KanbanModuleNavigator.PROYECTO,
                    KanbanModuleNavigator.ICON_PROYECTO,
                    KanbanModuleNavigator.NAV_PROYECTO,
                    new ProyectoDetailView()));

            list.add(DashBoardComponent.from(
                    KanbanModuleNavigator.COLUMNA,
                    KanbanModuleNavigator.ICON_COLUMNA,
                    KanbanModuleNavigator.NAV_COLUMNA,
                    new ColumnaDetailView()));

            list.add(DashBoardComponent.from(
                    KanbanModuleNavigator.PRIORIDAD,
                    KanbanModuleNavigator.ICON_PRIORIDAD,
                    KanbanModuleNavigator.NAV_PRIORIDAD,
                    new PrioridadDetailMainPanel()));

        } catch (Exception e) {
        }
        return list;
    }
}
