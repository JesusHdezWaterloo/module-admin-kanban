package com.jhw.gestion.modules.admin.ui.proyecto;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import java.awt.event.ActionListener;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ProyectoICBS extends InputComboBoxSelection<ProyectoDomain> {

    public ProyectoICBS() {
        setLabel("Proyecto");
        setIcon(KanbanModuleNavigator.ICON_PROYECTO);
    }

    @Override
    public List<ProyectoDomain> getList() throws Exception {
        return KanbanSwingModule.proyectoUC.findAll();
    }

    @Override
    public ModelPanel<ProyectoDomain> inputPanel() {
        return ProyectoInputView.from();
    }

}
