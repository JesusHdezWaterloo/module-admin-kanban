package com.jhw.gestion.modules.admin.ui.tipo_salario;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.admin.core.domain.EmpleadoDomain;
import com.jhw.gestion.modules.admin.core.domain.TipoSalarioDomain;
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
public class TipoSalarioDetailView extends _MaterialPanelDetail<TipoSalarioDomain> {

    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_DESC = "Descripción";

    public TipoSalarioDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_DESC).build()
        );

        this.personalize();
    }

    private void personalize() {
        //addActionsExtra();

        this.setHeaderText("Tipos de salario");
        this.setIcon(NominaModuleNavigator.ICON_TIPO_SALARIO);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(NominaSwingModule.tipoSalarioUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(TipoSalarioDomain obj) {
        return new Object[]{
            obj.getNombreTipoSalario(),
            obj.getDescripcion()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, TipoSalarioInputView.from());
    }

    @Override
    protected TipoSalarioDomain deleteAction(TipoSalarioDomain obj) {
        try {
            return NominaSwingModule.tipoSalarioUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(TipoSalarioDomain obj) {
        new DialogModelInput(this, TipoSalarioInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(TipoSalarioDomain obj) {
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
