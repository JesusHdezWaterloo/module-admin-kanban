package com.jhw.gestion.modules.admin.ui.contrato_empleado;

import com.jhw.gestion.modules.admin.core.domain.ContratoEmpleadoDomain;
import com.jhw.gestion.modules.admin.core.domain.EmpleadoDomain;
import com.jhw.gestion.modules.admin.core.domain.PuestoTrabajoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.gestion.modules.admin.ui.puesto_trabajo.PuestoTrabajoICBS;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.datepicker._MaterialDatePickerIcon;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ContratoEmpleadoInputView extends CleanCRUDInputView<ContratoEmpleadoDomain> {

    public static ContratoEmpleadoInputView from() {
        return new ContratoEmpleadoInputView(null);
    }

    public static ContratoEmpleadoInputView from(EmpleadoDomain empleado) {
        ContratoEmpleadoInputView ctto = new ContratoEmpleadoInputView(null);
        ctto.setEmpleado(empleado);
        return ctto;
    }

    public static ContratoEmpleadoInputView from(PuestoTrabajoDomain puesto) {
        ContratoEmpleadoInputView ctto = new ContratoEmpleadoInputView(null);
        ctto.setPuesto(puesto);
        return ctto;
    }

    public static ContratoEmpleadoInputView fromModel(ContratoEmpleadoDomain model) {
        return new ContratoEmpleadoInputView(model);
    }

    private ContratoEmpleadoInputView(ContratoEmpleadoDomain model) {
        super(model, NominaSwingModule.contratoTrabajadorUC, ContratoEmpleadoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Contrato", "Editar Contrato");

        empleadoICBS = new EmpleadoICBS();
        puestoICBS = new PuestoTrabajoICBS();

        fechaInicio = new _MaterialDatePickerIcon("Inicio");
        fechaFin = new _MaterialDatePickerIcon("Fin");

        textAreaDescripcion  = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(empleadoICBS);
        vlc.add(puestoICBS);

        HorizontalLayoutContainer.builder hlcFechas = HorizontalLayoutContainer.builder();
        hlcFechas.add(HorizontalLayoutComponent.builder(fechaInicio).gapRight(5).build());
        hlcFechas.add(HorizontalLayoutComponent.builder(fechaFin).gapLeft(5).build());
        vlc.add(hlcFechas.build());

        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private EmpleadoICBS empleadoICBS;
    private PuestoTrabajoICBS puestoICBS;
    private _MaterialDatePickerIcon fechaInicio;
    private _MaterialDatePickerIcon fechaFin;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("fechaInicio", fechaInicio);
        map.put("fechaFin", fechaFin);
        map.put("empleadoFk", empleadoICBS);
        map.put("puestoTrabajoFk", puestoICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

    private void setEmpleado(EmpleadoDomain empleado) {
        this.empleadoICBS.setObject(empleado);
    }

    private void setPuesto(PuestoTrabajoDomain puesto) {
        this.puestoICBS.setObject(puesto);
    }

}
