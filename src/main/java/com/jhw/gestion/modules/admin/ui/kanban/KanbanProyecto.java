/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.ColumnaDomain;
import com.jhw.gestion.modules.admin.core.domain.ColumnaProyectVolatile;
import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.utils.interfaces.Update;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanProyecto extends _PanelGradient implements Update, PropertyChangeListener {

    public static KanbanProyecto from(ProyectoDomain proyecto) {
        return new KanbanProyecto(proyecto);
    }

    private final ProyectoDomain proyecto;

    public KanbanProyecto(ProyectoDomain proyecto) {
        this.proyecto = proyecto;
        addPropertyListeners();
        update();
    }

    @Override
    public void update() {
        updateColumns();
    }

    private void updateColumns() {
        try {
            this.removeAll();//quito todo

            //busco las columnas
            List<ColumnaDomain> columnas = KanbanSwingModule.columnaUC.findAll();

            //pongo el layout en dependencia de las columnas
            this.setLayout(new GridLayout(1, columnas.size()));

            //relleno las columnas
            for (ColumnaDomain c : columnas) {
                this.add(KanbanColumn.from(new ColumnaProyectVolatile(proyecto, c)));
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
        switch (evt.getPropertyName()) {
            case "create":
                update();
                break;
            case "edit":
                update();
                break;
            case "destroy":
                update();
                break;
            case "destroyById":
                update();
                break;
        }
    }

    private void addPropertyListeners() {
        KanbanSwingModule.tareaUC.addPropertyChangeListener(this);
    }
}
