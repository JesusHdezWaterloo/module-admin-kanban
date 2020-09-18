package com.jhw.gestion.modules.admin.ui.contrato_empleado;

import com.jhw.gestion.modules.admin.core.domain.ContratoEmpleadoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import java.awt.event.ActionListener;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ContratoEmpleadoICBS extends InputComboBoxSelection<ContratoEmpleadoDomain> {

    public ContratoEmpleadoICBS() {
        super("Empleado");
        setIcon(NominaModuleNavigator.ICON_EMPLEADOS);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(NominaSwingModule.contratoTrabajadorUC.findAll());
    }

    @Override
    public ActionListener buttonAddAction() {
        return new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAddActionPerformed();
            }
        };
    }

    private void onButtonAddActionPerformed() {
        new DialogInputCBS(this, ContratoEmpleadoInputView.from());
    }

}
