package com.jhw.gestion.modules.admin.ui.proyecto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.clean.CleanDetailCRUDDragDrop;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ProyectoDetailView extends CleanDetailCRUDDragDrop<ProyectoDomain> {

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

    }

    @Override
    protected void personalize() {
        this.setAdjustColumns(true);
        this.setHeaderText("Proyectos activos");
        this.setIcon(KanbanModuleNavigator.ICON_PROYECTO);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    protected List<ProyectoDomain> getListUpdate() throws Exception {
        return KanbanSwingModule.proyectoUC.findAll();
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
    protected void addPropertyChange() {
        KanbanSwingModule.proyectoUC.addPropertyChangeListener(this);
    }

    @Override
    protected ModelPanel<ProyectoDomain> getModelPanelNew() {
        return ProyectoInputView.from();
    }

    @Override
    protected ModelPanel<ProyectoDomain> getModelPanelEdit(ProyectoDomain obj) {
        return ProyectoInputView.fromModel(obj);
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

}
