/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.swing.material.components.container.panel._PanelGradient;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanProyecto extends _PanelGradient {

    public static KanbanProyecto from(ProyectoDomain proyecto) {
        return new KanbanProyecto(proyecto);
    }
    
    private final ProyectoDomain proyecto;

    public KanbanProyecto(ProyectoDomain proyecto) {
        this.proyecto = proyecto;
    }

}
