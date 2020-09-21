/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.admin.ui.kanban;

import com.jhw.gestion.modules.admin.core.domain.TareaDomain;
import com.jhw.gestion.modules.admin.ui.tarea.TareaInputView;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
        addListeners();
        update();
    }

    private void initComponents() {
        setGap(0);

        this.setLayout(new BorderLayout());

        labelNombre = MaterialLabelsFactory.build();
        labelNombre.setFont(MaterialFontRoboto.BOLD.deriveFont(18f));
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);

        labelCodigo = MaterialLabelsFactory.build();
        labelCodigo.setFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        labelCodigo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel up = MaterialContainersFactory.buildPanelTransparent();
        up.setBorder(new EmptyBorder(5, 10, 0, 0));
        up.setLayout(new BorderLayout());
        up.add(labelCodigo, BorderLayout.WEST);
        up.add(labelNombre);
        this.add(up, BorderLayout.NORTH);

        buttonEdit = MaterialButtonsFactory.buildIconTransparent();
        buttonEdit.setRippleColor(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_EDIT));
        buttonEdit.setIcon(PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_EDIT));

        panelPrioridad = PrioridadSimplePanel.from();

        JPanel down = MaterialContainersFactory.buildPanelTransparent();
        down.setLayout(new BorderLayout());

        down.add(buttonEdit, BorderLayout.WEST);
        down.add(panelPrioridad, BorderLayout.EAST);
        this.add(down, BorderLayout.SOUTH);
    }

    private MaterialLabel labelCodigo;
    private MaterialLabel labelNombre;
    private MaterialButtonIcon buttonEdit;
    private PrioridadSimplePanel panelPrioridad;

    @Override
    public void update() {
        labelCodigo.setObject(tarea.getCodigoTarea());
        labelNombre.setObject(tarea.getNombreTarea());
        panelPrioridad.setObject(tarea.getPrioridadFk());//internamente actualiza
    }

    private void addListeners() {
        buttonEdit.addActionListener((ActionEvent e) -> {
            new DialogModelInput(TareaSimplePanel.this, TareaInputView.fromModel(tarea));
        });
    }
}
