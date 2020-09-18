package com.jhw.gestion.modules.admin.ui.prioridad;

import com.jhw.gestion.modules.admin.ui.columna.*;
import com.jhw.gestion.modules.admin.ui.proyecto.*;
import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.component.ComponentCellRender;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PrioridadDetailView extends _MaterialPanelDetail<PrioridadDomain> {

    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_VALOR = "Valor";
    private static final String COL_COLOR = "Color";

    public PrioridadDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_VALOR).build(),
                Column.builder().name(COL_COLOR).build()
        );
        this.personalize();
    }

    private void personalize() {
        //addActionsExtra();

        getTable().getColumn(COL_COLOR).setCellRenderer(new ComponentCellRender(false));

        this.setHeaderText("Prioridades");
        this.setIcon(KanbanModuleNavigator.ICON_PRIORIDAD);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(KanbanSwingModule.prioridadUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(PrioridadDomain obj) {
        return new Object[]{
            obj.getNombrePrioridad(),
            obj.getValorComparable(),
            getColorPanel(obj)};
    }

    private JPanel getColorPanel(PrioridadDomain obj) {
        try {
            JPanel p = MaterialContainersFactory.buildPanel();
            p.setBackground(new Color(obj.getColor()));
            return p;
        } catch (Exception e) {
        }
        return MaterialContainersFactory.buildPanelGradient();
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, PrioridadInputView.from());
    }

    @Override
    protected PrioridadDomain deleteAction(PrioridadDomain obj) {
        try {
            return KanbanSwingModule.prioridadUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(PrioridadDomain obj) {
        new DialogModelInput(this, PrioridadInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(PrioridadDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }
}
