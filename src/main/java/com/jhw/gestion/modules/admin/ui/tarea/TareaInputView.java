package com.jhw.gestion.modules.admin.ui.tarea;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.columna_proyecto.ColumnaProyectoICBS;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.gestion.modules.admin.ui.prioridad.PrioridadICBSPopup;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
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

    public static TareaInputView fromColumna(ColumnaProyectoDomain col) {
        TareaInputView tareaIC = from();
        tareaIC.columnaICBS.setObject(col);
        return tareaIC;
    }

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

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder();

        textFieldCodigo = MaterialTextFactory.buildIcon();
        textFieldCodigo.setHint("Código");
        textFieldCodigo.setLabel("Código");
        textFieldCodigo.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre de la tarea");
        textFieldNombre.setLabel("Tarea");

        hlc.add(textFieldCodigo);
        hlc.add(HorizontalLayoutComponent.builder(textFieldNombre).gapLeft(5).build());

        columnaICBS = new ColumnaProyectoICBS();
        prioridadICBS = new PrioridadICBSPopup();
        //textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(hlc.build());
        vlc.add(columnaICBS);
        vlc.add(prioridadICBS);
        //vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextFieldIcon textFieldCodigo;
    private ColumnaProyectoICBS columnaICBS;
    private PrioridadICBSPopup prioridadICBS;
    //private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("codigoTarea", textFieldCodigo);
        map.put("nombreTarea", textFieldNombre);
        map.put("colProyFk", columnaICBS);
        map.put("prioridadFk", prioridadICBS);
        //map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
