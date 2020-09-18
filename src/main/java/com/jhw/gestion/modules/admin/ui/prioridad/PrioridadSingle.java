package com.jhw.gestion.modules.admin.ui.prioridad;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.utils.interfaces.Update;
import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class PrioridadSingle extends _MaterialButton implements Update, BindableComponent<PrioridadDomain> {

    public static PrioridadSingle from(PrioridadDomain prioridad) {
        PrioridadSingle p = MaterialSwingInjector.getImplementation(PrioridadSingle.class);
        p.setObject(prioridad);
        return p;
    }

    private PrioridadDomain prioridad;

    @Deprecated
    public PrioridadSingle() {
        addListeners();
    }

    @Override
    public void update() {
        this.setText(prioridad.getNombrePrioridad());
        try {
            this.setBackground(new Color(prioridad.getColor()));
        } catch (Exception e) {
            this.setBackground(MaterialColors.TRANSPARENT);
        }
    }

    private void addListeners() {
        this.addActionListener((ActionEvent e) -> {
            new DialogModelInput(PrioridadSingle.this, PrioridadInputView.fromModel(prioridad));
        });
    }

    @Override
    public PrioridadDomain getObject() {
        return prioridad;
    }

    @Override
    public void setObject(PrioridadDomain t) {
        this.prioridad = t;
        update();
    }

}
