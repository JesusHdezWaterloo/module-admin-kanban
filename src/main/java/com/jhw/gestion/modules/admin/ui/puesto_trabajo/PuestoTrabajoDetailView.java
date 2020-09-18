package com.jhw.gestion.modules.admin.ui.puesto_trabajo;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.EmpleadoDomain;
import com.jhw.gestion.modules.admin.core.domain.PuestoTrabajoDomain;
import com.jhw.gestion.modules.admin.ui.contrato_empleado.ContratoEmpleadoInputView;
import com.jhw.gestion.modules.admin.ui.module.NominaModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PuestoTrabajoDetailView extends _MaterialPanelDetail<PuestoTrabajoDomain> {

    private static final String COL_NOMBRE = "Nombre";

    public PuestoTrabajoDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build()
        );

        this.personalize();
    }

    private void personalize() {
        addActionsExtra();

        this.setHeaderText("Puestos de trabajo");
        this.setIcon(NominaModuleNavigator.ICON_PUESTO_TRABAJO);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(NominaSwingModule.puestoTrabajoUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(PuestoTrabajoDomain obj) {
        return new Object[]{obj.getNombrePuestoTrabajo()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, PuestoTrabajoInputView.from());
    }

    @Override
    protected PuestoTrabajoDomain deleteAction(PuestoTrabajoDomain obj) {
        try {
            return NominaSwingModule.puestoTrabajoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(PuestoTrabajoDomain obj) {
        new DialogModelInput(this, PuestoTrabajoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(PuestoTrabajoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

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
    }
}
