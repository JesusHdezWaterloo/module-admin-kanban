package com.jhw.gestion.modules.admin.ui.prioridad;

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
public class PrioridadICBS extends InputComboBoxSelection<PrioridadDomain> {

    public PrioridadICBS() {
        super("Prioridad");
        setIcon(KanbanModuleNavigator.ICON_PROYECTO);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(KanbanSwingModule.prioridadUC.findAll());
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
        new DialogInputCBS(this, PrioridadInputView.from());
    }

}
