package com.jhw.gestion.modules.admin.ui.empleado;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.EmpleadoDomain;
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
public class EmpleadoDetailView extends _MaterialPanelDetail<EmpleadoDomain> {

    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_CI = "Carnet";
    private static final String COL_TELEFONO = "Teléfono";

    public EmpleadoDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_CI).build(),
                Column.builder().name(COL_TELEFONO).build()
        );

        this.personalize();
    }

    private void personalize() {
        addActionsExtra();
        
        this.setHeaderText("Empleados");
        this.setIcon(NominaModuleNavigator.ICON_EMPLEADOS);
        
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(NominaSwingModule.empleadoUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(EmpleadoDomain obj) {
        return new Object[]{
            obj.getNombreEmpleado(),
            obj.getCi(),
            obj.getTelefono()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, EmpleadoInputView.from());
    }

    @Override
    protected EmpleadoDomain deleteAction(EmpleadoDomain obj) {
        try {
            return NominaSwingModule.empleadoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(EmpleadoDomain obj) {
        new DialogModelInput(this, EmpleadoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(EmpleadoDomain obj) {
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
