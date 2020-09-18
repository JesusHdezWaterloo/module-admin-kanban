package com.jhw.gestion.modules.admin.ui.prioridad;

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
import com.jhw.swing.prepared.textfield.MaterialPreparedTextFactory;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PrioridadInputView extends CleanCRUDInputView<PrioridadDomain> {

    public static PrioridadInputView from() {
        return new PrioridadInputView(null);
    }

    public static PrioridadInputView fromModel(PrioridadDomain model) {
        return new PrioridadInputView(model);
    }

    private PrioridadInputView(PrioridadDomain model) {
        super(model, KanbanSwingModule.prioridadUC, PrioridadDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Prioridad", "Editar Prioridad");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre de la prioridad");
        textFieldNombre.setLabel("Prioridad");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldValor = MaterialPreparedTextFactory.buildIntegerIcon();
        textFieldValor.setIcon(MaterialIcons.ACCESS_ALARM);
        textFieldNombre.setHint("Valor para comparar");
        textFieldValor.setLabel("Valor");

        textFieldColor = MaterialPreparedTextFactory.buildIntegerIcon();
        textFieldColor.setIcon(MaterialIcons.ACCESS_ALARM);
        textFieldColor.setHint("Valor del color");
        textFieldColor.setLabel("Color");
        
        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textFieldValor);
        vlc.add(textFieldColor);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextFieldIcon textFieldValor;
    private MaterialTextFieldIcon textFieldColor;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombrePrioridad", textFieldNombre);
        map.put("descripcion", textAreaDescripcion);
        map.put("valorComparable", textAreaDescripcion);
        map.put("color", textAreaDescripcion);
        return map;
    }

}
