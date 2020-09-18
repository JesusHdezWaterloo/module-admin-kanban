/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.empleado;

import com.jhw.gestion.modules.admin.ui.puesto_trabajo.PuestoTrabajoDetailView;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EmpleadoMainPanel extends _PanelTransparent implements Update {

    public EmpleadoMainPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        empleadoDetail = new EmpleadoDetailView();
        puestoDetail = new PuestoTrabajoDetailView();

        this.add(empleadoDetail, BorderLayout.CENTER);
        this.add(puestoDetail, BorderLayout.EAST);
    }

    private EmpleadoDetailView empleadoDetail;
    private PuestoTrabajoDetailView puestoDetail;

    @Override
    public void update() {
        empleadoDetail.update();
        puestoDetail.update();
    }
}
