/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.container.panel.*;
import com.jhw.swing.material.components.labels.*;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.prepared.button.MaterialButtonAddEdit;
import com.jhw.swing.prepared.button.MaterialPreparedButtonsFactory;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanColumn extends _MaterialPanelComponent implements Update {

    private final static int DEFAULT_GAP = 0;

    public static KanbanColumn from(ColumnaProyectoDomain columna) {
        return new KanbanColumn(columna);
    }

    private final ColumnaProyectoDomain columna;

    public KanbanColumn(ColumnaProyectoDomain columna) {
        this.columna = columna;
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        this.setGap(DEFAULT_GAP);//gap para respetar el sombreado

        header = KanbanColumnHeader.from(columna);
        this.add(header, BorderLayout.NORTH);
    }
    private KanbanColumnHeader header;

    private void addAction() {
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

    private void addListeners() {
        header.addActionListenerButtonAdd((ActionEvent e) -> {
            addAction();
        });
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
            this.setGap(0);
            this.setBackground(MaterialColors.GREY_300);

            labelHeader = MaterialLabelsFactory.build();
            labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
            labelHeader.setFont(labelHeader.getFont().deriveFont(Font.BOLD));
            this.add(labelHeader);

            buttonAdd = MaterialPreparedButtonsFactory.buildAddEdit();
            buttonAdd.isCreated(true);
            buttonAdd.setText("");
            int w = (int) (2f * buttonAdd.getIcon().getIconWidth());
            buttonAdd.setPreferredSize(new Dimension(w, w - 5));//el menos para emparejar el tamaño por el border
            this.add(buttonAdd, BorderLayout.EAST);
        }

        private MaterialLabel labelHeader;
        private MaterialButtonAddEdit buttonAdd;

        public void setHeader(String text) {
            labelHeader.setText(text.toUpperCase());
        }

        public void addActionListenerButtonAdd(ActionListener listener) {
            buttonAdd.addActionListener(listener);
        }
    }
}
