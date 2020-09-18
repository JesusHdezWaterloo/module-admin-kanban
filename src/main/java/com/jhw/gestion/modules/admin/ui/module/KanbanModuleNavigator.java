package com.jhw.gestion.modules.admin.ui.module;

import com.clean.core.app.services.NavigationService;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.utils.icons.DerivableIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanModuleNavigator implements NavigationService {

    public static final String PROYECTO = "Proyecto";
    public static final String COLUMNA = "Columna";
    public static final String PRIORIDAD = "Prioridad";
    public static final String TAREA = "Tarea";

    public static final DerivableIcon ICON_PROYECTO = MaterialIcons.ACCOUNT_BOX;
    public static final DerivableIcon ICON_COLUMNA = MaterialIcons.ACCOUNT_BOX;
    public static final DerivableIcon ICON_PRIORIDAD = MaterialIcons.WARNING;
    public static final DerivableIcon ICON_TAREA = MaterialIcons.HOME;

    public static final String NAV_PROYECTO = "modulos.kanaban.proyecto";
    public static final String NAV_COLUMNA = "modulos.kanaban.columna";
    public static final String NAV_PRIORIDAD = "modulos.kanaban.prioridad";
    public static final String NAV_TAREA = "modulos.kanaban.tarea";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
        }
    }

}
