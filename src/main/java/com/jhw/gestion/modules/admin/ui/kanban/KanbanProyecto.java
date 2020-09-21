/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.ColumnaProyectoDomain;
import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.utils.interfaces.Update;
import java.awt.GridLayout;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanProyecto extends _PanelGradient implements Update {

    public static KanbanProyecto from(ProyectoDomain proyecto) {
        return new KanbanProyecto(proyecto);
    }

    private final ProyectoDomain proyecto;

    public KanbanProyecto(ProyectoDomain proyecto) {
        this.proyecto = proyecto;
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
            List<ColumnaProyectoDomain> columnas = KanbanSwingModule.columnaProyectoUC.findByProyecto(proyecto);

            //pongo el layout en dependencia de las columnas
            this.setLayout(new GridLayout(1, columnas.size()));

            //relleno las columnas
            for (ColumnaProyectoDomain c : columnas) {
                this.add(KanbanColumn.from(c));
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
