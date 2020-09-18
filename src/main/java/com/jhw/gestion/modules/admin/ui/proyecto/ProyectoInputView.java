package com.jhw.gestion.modules.admin.ui.proyecto;

import com.jhw.gestion.modules.admin.core.domain.ProyectoDomain;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.jhw.gestion.modules.contabilidad.ui.tipo_operacion.TipoOperacionContableICBS;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.datepicker.MaterialDatePickerIcon;
import com.jhw.swing.material.components.datepicker.MaterialDatePickersFactory;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ProyectoInputView extends CleanCRUDInputView<ProyectoDomain> {

    public static ProyectoInputView from() {
        return new ProyectoInputView(null);
    }

    public static ProyectoInputView fromModel(ProyectoDomain model) {
        return new ProyectoInputView(model);
    }

    private ProyectoInputView(ProyectoDomain model) {
        super(model, KanbanSwingModule.proyectoUC, ProyectoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Proyecto", "Editar Proyecto");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre del proyecto");
        textFieldNombre.setLabel("Proyecto");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        datePickerInicio = MaterialDatePickersFactory.buildIcon();
        datePickerInicio.setHint("Fecha de inicio del proyecto");
        datePickerInicio.setLabel("Inicio");

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialDatePickerIcon datePickerInicio;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreProyecto", textFieldNombre);
        map.put("fechaInicio", datePickerInicio);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
