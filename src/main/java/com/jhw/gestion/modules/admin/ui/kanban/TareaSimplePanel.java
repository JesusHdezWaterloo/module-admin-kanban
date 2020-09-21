/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.jhw.gestion.modules.admin.core.domain.TareaDomain;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TareaSimplePanel extends _MaterialPanelComponent implements Update {

    public static TareaSimplePanel from(TareaDomain tarea) {
        return new TareaSimplePanel(tarea);
    }

    private final TareaDomain tarea;

    public TareaSimplePanel(TareaDomain tarea) {
        this.tarea = tarea;
        initComponents();
        update();
    }

    private void initComponents() {
        setGap(0);
        this.setLayout(new BorderLayout());

        header = MaterialLabelsFactory.build();
        header.setFont(MaterialFontRoboto.BOLD.deriveFont(20f));
        header.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel up = MaterialContainersFactory.buildPanelTransparent();
        up.setLayout(new BorderLayout());
        up.add(header);
        this.add(up, BorderLayout.NORTH);

        buttonEdit = MaterialButtonsFactory.buildIconTransparent();
        buttonEdit.setRippleColor(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_EDIT));
        buttonEdit.setIcon(PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_EDIT));

        panelPrioridad = PrioridadSimplePanel.from(tarea.getPrioridadFk());

        JPanel down = MaterialContainersFactory.buildPanelTransparent();
        down.setLayout(new BorderLayout());

        down.add(buttonEdit, BorderLayout.WEST);
        down.add(panelPrioridad, BorderLayout.EAST);
        this.add(down, BorderLayout.SOUTH);
    }

    private MaterialLabel header;
    private MaterialButtonIcon buttonEdit;
    private PrioridadSimplePanel panelPrioridad;

    @Override
    public void update() {
        header.setObject(tarea.getNombreTarea());
    }
}
