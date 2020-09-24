/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.ColumnaProyectoDomain;
import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.columna_proyecto.ColumnaProyectoInputView;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.prepared.button.MaterialButtonAddEdit;
import com.jhw.swing.prepared.button.MaterialPreparedButtonsFactory;
import com.jhw.utils.interfaces.Update;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanProyectoHeader extends _MaterialPanelComponent {

    public static KanbanProyectoHeader from(ProyectoDomain proyecto) {
        return new KanbanProyectoHeader(proyecto);
    }

    private final ProyectoDomain proyecto;

    public KanbanProyectoHeader(ProyectoDomain proyecto) {
        this.proyecto = proyecto;
        initComponents();
        addListeners();
    }

    private void initComponents() {
        buttonAddColumn = MaterialPreparedButtonsFactory.buildAddEdit();
        buttonAddColumn.isCreated(true);
        buttonAddColumn.setText("Columna");
    }

    private MaterialButtonAddEdit buttonAddColumn;

    private void addListeners() {
        buttonAddColumn.addActionListener((ActionEvent e) -> {
            DialogModelInput.from(ColumnaProyectoInputView.from(proyecto));
        });
    }
}
