package com.jhw.gestion.modules.admin.ui.columna_proyecto;

import com.jhw.gestion.modules.admin.ui.columna.*;
import com.jhw.gestion.modules.admin.ui.proyecto.*;
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
public class ColumnaProyectoICBS extends InputComboBoxSelection<ColumnaProyectoDomain> {

    public ColumnaProyectoICBS() {
        setLabel("Columna");
        setIcon(KanbanModuleNavigator.ICON_COLUMNA);
    }

    @Override
    public List<ColumnaProyectoDomain> getList() throws Exception {
        return KanbanSwingModule.columnaProyectoUC.findAll();
    }

    @Override
    public ModelPanel<ColumnaProyectoDomain> inputPanel() {
        return null;//ColumnaInputView.from();
    }

    @Override
    protected void addPropertyChange() {
        KanbanSwingModule.columnaProyectoUC.addPropertyChangeListener(this);
    }
}
