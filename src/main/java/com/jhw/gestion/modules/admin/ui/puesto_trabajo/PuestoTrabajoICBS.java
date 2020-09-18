package com.jhw.gestion.modules.admin.ui.puesto_trabajo;

import com.jhw.gestion.modules.admin.core.domain.PuestoTrabajoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import java.awt.event.ActionListener;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PuestoTrabajoICBS extends InputComboBoxSelection<PuestoTrabajoDomain> {

    public PuestoTrabajoICBS() {
        super("Puesto de Trabajos");
        setIcon(NominaModuleNavigator.ICON_PUESTO_TRABAJO);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(NominaSwingModule.puestoTrabajoUC.findAll());
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
        new DialogInputCBS(this, PuestoTrabajoInputView.from());
    }

}
