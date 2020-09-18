package com.jhw.gestion.modules.admin.ui.module;

import com.clean.core.app.services.NavigationService;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.utils.icons.DerivableIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NominaModuleNavigator implements NavigationService {

    public static final String NOMINA = "Nómina";
    public static final String CONTRATOS = "Contratos";
    public static final String EMPLEADOS = "Empleados";
    public static final String SALARIOS = "Salarios";
    public static final String TIPOS_SALARIOS = "Tipos de salarios";

    public static final DerivableIcon ICON_NOMINA = MaterialIcons.ACCOUNT_BOX;
    public static final DerivableIcon ICON_CONTRATOS = MaterialIcons.ASSIGNMENT_IND;
    public static final DerivableIcon ICON_EMPLEADOS = MaterialIcons.PERSON_ADD;
    public static final DerivableIcon ICON_SALARIOS = MaterialIcons.MONETIZATION_ON;
    public static final DerivableIcon ICON_TIPO_SALARIO = MaterialIcons.HOT_TUB;
    public static final DerivableIcon ICON_PUESTO_TRABAJO = MaterialIcons.PIN_DROP;

    public static final String NAV_CONTRATOS = "modulos.nomina.contratos";
    public static final String NAV_EMPLEADOS = "modulos.nomina.empleados";
    public static final String NAV_SALARIOS = "modulos.nomina.salarios";
    public static final String NAV_TIPOS_SALARIOS = "modulos.nomina.tipos_salarios";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
        }
    }

}
