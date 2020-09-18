package com.jhw.gestion.modules.admin.ui.tarea;

import com.jhw.gestion.modules.admin.ui.columna.*;
import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
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
public class TareaInputView extends CleanCRUDInputView<TareaDomain> {

    public static TareaInputView from() {
        return new TareaInputView(null);
    }

    public static TareaInputView fromModel(TareaDomain model) {
        return new TareaInputView(model);
    }

    private TareaInputView(TareaDomain model) {
        super(model, KanbanSwingModule.tareaUC, TareaDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tarea", "Editar Tarea");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre de la tarea");
        textFieldNombre.setLabel("Tarea");
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
        map.put("nombreColumna", textFieldNombre);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
