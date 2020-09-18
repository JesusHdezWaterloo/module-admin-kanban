package com.jhw.gestion.modules.admin.ui.contrato_empleado;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.jhw.gestion.modules.admin.core.domain.ContratoEmpleadoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.utils.others.SDF;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ContratoEmpleadoDetailView extends _MaterialPanelDetail<ContratoEmpleadoDomain> {

    private static final String COL_EMPLEADO = "Empleado";
    private static final String COL_PUESTO = "Puesto";
    private static final String COL_INICIO = "Inicio";
    private static final String COL_FIN = "Fin";
    private static final String COL_ACTIVO = "Activo";

    public ContratoEmpleadoDetailView() {
        super(
                Column.builder().name(COL_EMPLEADO).build(),
                Column.builder().name(COL_PUESTO).build(),
                Column.builder().name(COL_INICIO).build(),
                Column.builder().name(COL_FIN).build(),
                Column.builder().name(COL_ACTIVO).build()
        );

        this.personalize();
    }

    private void personalize() {
        addActionsExtra();
        
        this.setHeaderText("Contratos");
        this.setIcon(NominaModuleNavigator.ICON_CONTRATOS);
        
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(NominaSwingModule.contratoTrabajadorUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(ContratoEmpleadoDomain obj) {
        return new Object[]{
            obj.getEmpleadoFk(),
            obj.getPuestoTrabajoFk(),
            SDF.SDF.format(obj.getFechaInicio()),
            SDF.SDF.format(obj.getFechaFin()),
            obj.getActivo() ? "SI" : "NO"};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, ContratoEmpleadoInputView.from());
    }

    @Override
    protected ContratoEmpleadoDomain deleteAction(ContratoEmpleadoDomain obj) {
        try {
            return NominaSwingModule.contratoTrabajadorUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(ContratoEmpleadoDomain obj) {
        new DialogModelInput(this, ContratoEmpleadoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(ContratoEmpleadoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addActionsExtra() {
        this.addActionExtra(new AbstractAction("Activar/Cancelar", MaterialIcons.UPDATE.deriveIcon(18f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCambiarEstadoActionPerformed();
            }

        });
    }

    private void onCambiarEstadoActionPerformed() {
        ContratoEmpleadoDomain selected = getSelectedElement();
        if (selected != null) {
            String text = selected.getActivo() ? "CANCELAR" : "ACTIVAR";
            if (Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_GENERAL, "Seguro desea " + text + " el contrato con " + selected + "?")) {
                try {
                    NominaSwingModule.contratoTrabajadorUC.cambiarEstado(selected);
                    update();
                } catch (Exception e) {
                    ExceptionHandler.handleException(e);
                }
            }
        }

    }
}
