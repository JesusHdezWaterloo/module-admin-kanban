package com.jhw.gestion.modules.admin.ui.puesto_trabajo;

import com.jhw.gestion.modules.admin.core.domain.PuestoTrabajoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
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
public class PuestoTrabajoInputView extends CleanCRUDInputView<PuestoTrabajoDomain> {

    public static PuestoTrabajoInputView from() {
        return new PuestoTrabajoInputView(null);
    }

    public static PuestoTrabajoInputView fromModel(PuestoTrabajoDomain model) {
        return new PuestoTrabajoInputView(model);
    }

    private PuestoTrabajoInputView(PuestoTrabajoDomain model) {
        super(model, NominaSwingModule.puestoTrabajoUC, PuestoTrabajoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Puesto de trabajo", "Editar Puesto de trabajo");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre del trabajador");
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombrePuestoTrabajo", textFieldNombre);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
