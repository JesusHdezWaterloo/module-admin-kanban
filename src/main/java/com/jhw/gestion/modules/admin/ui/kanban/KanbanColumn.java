/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.gestion.modules.admin.ui.tarea.TareaInputView;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.container.panel.*;
import com.jhw.swing.material.components.labels.*;
import com.jhw.swing.material.components.scrollpane.MaterialScrollFactory;
import com.jhw.swing.material.components.scrollpane.MaterialScrollPane;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.prepared.button.MaterialButtonAddEdit;
import com.jhw.swing.prepared.button.MaterialPreparedButtonsFactory;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanColumn extends _MaterialPanelComponent implements Update {

    private final static int DEFAULT_GAP = 0;

    public static KanbanColumn from(ColumnaProyectVolatile colProy) {
        return new KanbanColumn(colProy);
    }
    private final ColumnaProyectVolatile colProy;

    public KanbanColumn(ColumnaProyectVolatile colProy) {
        this.colProy = colProy;
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        this.setGap(DEFAULT_GAP);//gap para respetar el sombreado

        header = KanbanColumnHeader.from(colProy);
        this.add(header, BorderLayout.NORTH);

        panelTareas = MaterialContainersFactory.buildPanelTransparent();
        panelTareas.setLayout(new BorderLayout());

        //----------------con scroll----------------
        MaterialScrollPane scroll = MaterialScrollFactory.buildPane();
        scroll.remove(scroll.getHorizontalScrollBar());
        scroll.setViewportView(panelTareas);
        this.add(scroll);
        //----------------con scroll----------------

        //----------------sin scroll----------------
        //this.add(panelTareas);
        //----------------sin scroll----------------
    }

    private KanbanColumnHeader header;
    private JPanel panelTareas;

    @Override
    public void update() {
        updateColumn();
    }

    private void updateColumn() {
        try {
            panelTareas.removeAll();
            VerticalLayoutContainer.builder vlcTareas = VerticalLayoutContainer.builder((int) panelTareas.getPreferredSize().getWidth());

            for (TareaDomain tarea : KanbanSwingModule.tareaUC.findByColumnaProyecto(colProy)) {
                vlcTareas.add(TareaSimplePanel.from(tarea));
            }

            panelTareas.add(vlcTareas.build());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private void addListeners() {
        header.addActionListenerButtonAdd((ActionEvent e) -> {
            //new DialogModelInput(this, TareaInputView.fromColumna(colProy));
        });
    }

    private static class KanbanColumnHeader extends _MaterialPanelComponent {

        public static KanbanColumnHeader from(ColumnaProyectVolatile colProy) {
            KanbanColumnHeader columnHeader = MaterialSwingInjector.getImplementation(KanbanColumnHeader.class);
            columnHeader.setHeader(colProy.getColumna().getNombreColumna());
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
            labelHeader.setObject(text.toUpperCase());
        }

        public void addActionListenerButtonAdd(ActionListener listener) {
            buttonAdd.addActionListener(listener);
        }
    }
}
