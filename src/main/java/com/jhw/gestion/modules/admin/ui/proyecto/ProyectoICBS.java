package com.jhw.gestion.modules.admin.ui.proyecto;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import java.awt.event.ActionListener;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ProyectoICBS extends InputComboBoxSelection<ProyectoDomain> {

    public ProyectoICBS() {
        super("Tipo Salario");
        setIcon(KanbanModuleNavigator.ICON_PROYECTO);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(KanbanSwingModule.proyectoUC.findAll());
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
        new DialogInputCBS(this, ProyectoInputView.from());
    }

}
