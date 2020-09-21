/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.gestion.modules.admin.ui.tarea.TareaSimplePanel;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.container.panel.*;
import com.jhw.swing.material.components.labels.*;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanColumn extends _PanelTransparent implements Update {

    public static KanbanColumn from(ColumnaProyectoDomain columna) {
        return new KanbanColumn(columna);
    }

    private final ColumnaProyectoDomain columna;

    public KanbanColumn(ColumnaProyectoDomain columna) {
        this.columna = columna;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(KanbanColumnHeader.from(columna), BorderLayout.NORTH);
    }

    @Override
    public void update() {
        updateColumn();
    }

    private void updateColumn() {
        try {
            List<TareaDomain> tareas = KanbanSwingModule.tareaUC.findByColumnaProyecto(columna);
            VerticalLayoutContainer.builder vlcTareas = VerticalLayoutContainer.builder();

            for (TareaDomain tarea : tareas) {
                vlcTareas.add(TareaSimplePanel.from(tarea));
            }

            this.add(vlcTareas.build());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private static class KanbanColumnHeader extends _MaterialPanelComponent {

        public static KanbanColumnHeader from(ColumnaProyectoDomain col) {
            KanbanColumnHeader columnHeader = MaterialSwingInjector.getImplementation(KanbanColumnHeader.class);
            columnHeader.setHeader(col.getColumnaFk().getNombreColumna());
            return columnHeader;
        }

        public KanbanColumnHeader() {
            initComponents();
        }

        private void initComponents() {
            labelHeader = MaterialLabelsFactory.build();
            this.add(labelHeader);
        }
        private MaterialLabel labelHeader;

        public void setHeader(String text) {
            labelHeader.setText(text);
        }
    }
}
