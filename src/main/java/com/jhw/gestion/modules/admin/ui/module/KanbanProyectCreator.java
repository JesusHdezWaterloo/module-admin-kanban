/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.module;

import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.kanban.KanbanProyecto;
import com.jhw.gestion.modules.admin.ui.kanban.KanbanProyecto;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.utils.security.SHA;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class KanbanProyectCreator {

    public static Icon ICON_KANBAN = MaterialIcons.TEC_NB;

    public static List<KanbanProyectCreator> createKanbansProjects() {
        List<KanbanProyectCreator> list = new ArrayList<>();
        try {
            for (ProyectoDomain proyectoDomain : KanbanSwingModule.proyectoUC.findAll()) {
                list.add(new KanbanProyectCreator(
                        proyectoDomain.getNombreProyecto(),
                        ICON_KANBAN,
                        KanbanModuleNavigator.GROUP + "." + proyectoDomain.getNombreProyecto(),
                        KanbanProyecto.from(proyectoDomain)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    String name;
    Icon icon;
    String nav;
    JComponent view;

    public KanbanProyectCreator(String name, Icon icon, String nav, JComponent view) {
        this.name = name;
        this.icon = icon;
        this.nav = nav;
        this.view = view;
    }

}
