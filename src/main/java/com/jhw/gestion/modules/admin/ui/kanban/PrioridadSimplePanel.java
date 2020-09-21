/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.jhw.gestion.modules.admin.core.domain.PrioridadDomain;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PrioridadSimplePanel extends _MaterialPanelComponent implements Update {

    public static PrioridadSimplePanel from(PrioridadDomain prioridad) {
        return new PrioridadSimplePanel(prioridad);
    }

    private final PrioridadDomain prioridad;

    public PrioridadSimplePanel(PrioridadDomain prioridad) {
        this.prioridad = prioridad;
        initComponents();
        update();
    }

    private void initComponents() {
        setGap(5);
        labelPrioridad = MaterialLabelsFactory.build();
        labelPrioridad.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(labelPrioridad);

    }
    private MaterialLabel labelPrioridad;

    @Override
    public void update() {
        Color back = new Color(prioridad.getColor());

        labelPrioridad.setBackground(back);
        labelPrioridad.setObject(prioridad.getNombrePrioridad());

        this.setToolTipText(prioridad.getDescripcion());

        this.setBackground(back);
    }
}
