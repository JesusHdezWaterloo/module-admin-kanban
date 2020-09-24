package com.jhw.gestion.modules.admin.ui.tarea;

import com.jhw.gestion.modules.admin.core.domain.*;
import com.jhw.gestion.modules.admin.ui.columna.ColumnaICBS;
import com.jhw.gestion.modules.admin.ui.module.KanbanSwingModule;
import com.jhw.gestion.modules.admin.ui.prioridad.PrioridadICBSPopup;
import com.jhw.gestion.modules.admin.ui.proyecto.ProyectoICBS;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.*;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.jhw.swing.prepared.textfield.MaterialPreparedTextFactory;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TareaInputView extends CleanCRUDInputView<TareaDomain> {

    public static TareaInputView fromColumna(ColumnaProyectVolatile colProy) {
        TareaInputView tareaIC = from();
        tareaIC.columnaICBS.setObject(colProy.getColumna());
        tareaIC.proyectoICBS.setObject(colProy.getProyecto());
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

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre de la tarea");
        textFieldNombre.setLabel("Tarea");

        textFieldCodigo = MaterialTextFactory.buildIcon();
        textFieldCodigo.setHint("Código");
        textFieldCodigo.setLabel("Código");
        textFieldCodigo.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldPuntos = MaterialPreparedTextFactory.buildInteger();
        textFieldPuntos.setHint("Puntos de la tarea");
        textFieldPuntos.setLabel("Puntos");

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder();

        hlc.add(textFieldCodigo);
        hlc.add(HorizontalLayoutComponent.builder(textFieldPuntos).gapLeft(5).build());

        prioridadICBS = new PrioridadICBSPopup();
        //textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(hlc.build());
        vlc.add(proyectoICBS);
        vlc.add(columnaICBS);
        vlc.add(prioridadICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon<String> textFieldNombre;
    private MaterialTextFieldIcon textFieldCodigo;
    private MaterialTextField<Integer> textFieldPuntos;
    private ColumnaICBS columnaICBS;
    private ProyectoICBS proyectoICBS;
    private PrioridadICBSPopup prioridadICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreTarea", textFieldNombre);
        map.put("codigoTarea", textFieldCodigo);
        map.put("prioridadFk", prioridadICBS);
        map.put("puntos", textFieldPuntos);
        map.put("columnaFk", columnaICBS);
        map.put("proyectoFk", proyectoICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
