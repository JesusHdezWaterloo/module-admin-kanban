package com.jhw.gestion.modules.admin.ui.empleado;

import com.jhw.gestion.modules.admin.core.domain.EmpleadoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class EmpleadoInputView extends CleanCRUDInputView<EmpleadoDomain> {

    public static EmpleadoInputView from() {
        return new EmpleadoInputView(null);
    }

    public static EmpleadoInputView fromModel(EmpleadoDomain model) {
        return new EmpleadoInputView(model);
    }

    private EmpleadoInputView(EmpleadoDomain model) {
        super(model, NominaSwingModule.empleadoUC, EmpleadoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Empleado", "Editar Empleado");

        textFieldNombre = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setHint("Nombre del trabajador");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldCI = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldCI.setHint("Carnet de identidad del trabajador");
        textFieldCI.setLabel("CI");
        textFieldCI.setMaxLength(11);
        textFieldCI.setIcon(MaterialIcons.FINGERPRINT);

        textFieldDireccion = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldDireccion.setHint("Introduzca la dirección del trabajador");
        textFieldDireccion.setLabel("Dirección");
        textFieldDireccion.setIcon(MaterialIcons.PERSON_PIN_CIRCLE);

        textFieldTelefono = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldTelefono.setHint("Introduzca el teléfono del trabajador");
        textFieldTelefono.setLabel("Teléfono");
        textFieldTelefono.setIcon(MaterialIcons.PHONE_IPHONE);

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textFieldCI);
        vlc.add(textFieldDireccion);
        vlc.add(textFieldTelefono);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextArea textAreaDescripcion;
    private MaterialTextFieldIcon textFieldCI;
    private MaterialTextFieldIcon textFieldTelefono;
    private MaterialTextFieldIcon textFieldDireccion;
    private MaterialTextFieldIcon textFieldNombre;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("ci", textFieldCI);
        map.put("nombreEmpleado", textFieldNombre);
        map.put("telefono", textFieldTelefono);
        map.put("direccion", textFieldDireccion);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
