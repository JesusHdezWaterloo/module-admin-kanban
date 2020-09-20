/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.jhw.gestion.modules.admin.core.domain.ColumnaDomain;
import com.jhw.gestion.modules.admin.core.domain.ColumnaProyectoDomain;
import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.utils.interfaces.Update;
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
    }

    private void initComponents() {
        List<ColumnaProyectoDomain> columnas = KanbanSwingModule.columnaProyectoUC.findByProyecto(proyecto);

    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
