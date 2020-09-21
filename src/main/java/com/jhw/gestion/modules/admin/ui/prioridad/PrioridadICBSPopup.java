package com.jhw.gestion.modules.admin.ui.prioridad;

import com.jhw.gestion.modules.admin.core.domain.PrioridadDomain;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.models.example.*;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.example.MATERIAL_ICONS_EXAMPLE;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import com.jhw.swing.models.input.popup_selection.InputPopupSelection;
import com.jhw.swing.util.AbstractActionUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PrioridadICBSPopup extends InputPopupSelection<PrioridadDomain> {

    public static final String TEXT = "Prioridad";

    public PrioridadICBSPopup() {
        getComponent().setIcon(MaterialIcons.PEOPLE);
        getComponent().setText(TEXT);
    }

    @Override
    public List<PrioridadDomain> getList() throws Exception {
        return KanbanSwingModule.prioridadUC.findAll();
    }

    @Override
    protected Action convert(PrioridadDomain obj) {
        Action a = AbstractActionUtils.from(obj.getNombrePrioridad(), MaterialIcons.ADD);
        a.putValue(AbstractActionUtils.KEY_BACKGROUND, new Color(obj.getColor()));
        return a;
    }

    @Override
    public ModelPanel<PrioridadDomain> inputPanel() {//input para el agregar
        return PrioridadInputView.from();
    }

    @Override
    public void select(PrioridadDomain cargo) {//cambios visuales para cuando se selecciona
        //getComponent().getButton().setIcon(MATERIAL_ICONS_EXAMPLE.getRandomIcon());
        getComponent().setText(TEXT + " (" + cargo + ")");
        getComponent().getButton().setBackground(new Color(cargo.getColor()));
    }
}