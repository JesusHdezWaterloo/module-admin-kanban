package com.jhw.gestion.modules.admin.ui.columna;

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
public class ColumnaICBS extends InputComboBoxSelection<ColumnaDomain> {

    public ColumnaICBS() {
        setLabel("Columna");
        setIcon(KanbanModuleNavigator.ICON_PROYECTO);
    }

    @Override
    public List<ColumnaDomain> getList() throws Exception {
        return KanbanSwingModule.columnaUC.findAll();
    }

    @Override
    public ModelPanel<ColumnaDomain> inputPanel() {
        return ColumnaInputView.from();
    }

}
