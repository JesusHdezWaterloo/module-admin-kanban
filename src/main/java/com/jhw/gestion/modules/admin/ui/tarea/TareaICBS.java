package com.jhw.gestion.modules.admin.ui.tarea;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TareaICBS extends InputComboBoxSelection<TareaDomain> {

    public TareaICBS() {
        setLabel("Tarea");
        setIcon(KanbanModuleNavigator.ICON_TAREA);
    }

    @Override
    public List<TareaDomain> getList() throws Exception {
        return KanbanSwingModule.tareaUC.findAll();
    }

    @Override
    public ModelPanel<TareaDomain> inputPanel() {
        return TareaInputView.from();
    }
}
