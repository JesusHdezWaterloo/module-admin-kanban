package com.jhw.gestion.modules.admin.ui.proyecto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ProyectoDetailView extends _MaterialPanelDetail<ProyectoDomain> {

    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_PRIORIDAD = "Prioridad";
    private static final String COL_KANBAN = "Kanban";
    private static final String COL_URL_LOCAL = "URL Local";
    private static final String COL_URL_ONLINE = "URL Online";

    public ProyectoDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_PRIORIDAD).build(),
                Column.builder().name(COL_KANBAN).build(),
                Column.builder().name(COL_URL_LOCAL).build(),
                Column.builder().name(COL_URL_ONLINE).build()
        );

        this.personalize();
    }

    private void personalize() {
        //addActionsExtra();
        this.setAdjustColumns(true);
        this.setHeaderText("Proyectos activos");
        this.setIcon(KanbanModuleNavigator.ICON_PROYECTO);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(KanbanSwingModule.proyectoUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(ProyectoDomain obj) {
        return new Object[]{
            obj.getNombreProyecto(),
            obj.getPrioridad(),
            obj.isKanban() ? "SI" : "NO",
            obj.getUrlLocal(),
            obj.getUrlRepoOnline()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, ProyectoInputView.from());
    }

    @Override
    protected ProyectoDomain deleteAction(ProyectoDomain obj) {
        try {
            return KanbanSwingModule.proyectoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(ProyectoDomain obj) {
        new DialogModelInput(this, ProyectoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(ProyectoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }
    /*
    private void addActionsExtra() {
        this.addActionExtra(new AbstractAction("Contratar", MaterialIcons.ASSIGNMENT_IND.deriveIcon(18f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onContratarEmpleadoActionPerformed();
            }
        });
    }

    private void onContratarEmpleadoActionPerformed() {
        new DialogModelInput(this, ContratoEmpleadoInputView.from(getSelectedElement()));
    }*/
}
