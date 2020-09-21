/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.tarea;

import com.jhw.gestion.modules.admin.core.domain.TareaDomain;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TareaSimplePanel extends _MaterialPanel implements Update {

    public static TareaSimplePanel from(TareaDomain tarea) {
        return new TareaSimplePanel(tarea);
    }

    private final TareaDomain tarea;

    public TareaSimplePanel(TareaDomain tarea) {
        initComponents();
        this.tarea = tarea;
        update();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        header = MaterialLabelsFactory.build();
        this.add(header, BorderLayout.NORTH);
    }
    private MaterialLabel header;

    @Override
    public void update() {
        header.setObject(tarea.getNombreTarea());
    }
}
