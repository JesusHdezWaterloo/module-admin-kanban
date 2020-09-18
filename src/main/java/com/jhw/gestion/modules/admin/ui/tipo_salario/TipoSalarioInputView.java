package com.jhw.gestion.modules.admin.ui.tipo_salario;

import com.jhw.gestion.modules.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.jhw.gestion.modules.contabilidad.ui.tipo_operacion.TipoOperacionContableICBS;
import com.jhw.gestion.modules.admin.core.domain.TipoSalarioDomain;
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
public class TipoSalarioInputView extends CleanCRUDInputView<TipoSalarioDomain> {

    public static TipoSalarioInputView from() {
        return new TipoSalarioInputView(null);
    }

    public static TipoSalarioInputView fromModel(TipoSalarioDomain model) {
        return new TipoSalarioInputView(model);
    }

    private TipoSalarioInputView(TipoSalarioDomain model) {
        super(model, NominaSwingModule.tipoSalarioUC, TipoSalarioDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de salario", "Editar Tipo de salario");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre del salario");
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textAreaDescripcion  = MaterialPreparedTextAreaFactory.buildDescripcion();

        monedaICBS = new com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS();
        monedaICBS.setLabel("Moneda por defecto");
        monedaICBS.setIcon(MaterialIcons.ATTACH_MONEY);
        
        tipoOpICBS = new TipoOperacionContableICBS();
        tipoOpICBS.setLabel("Operación contable por defecto");

        formaPagoICBS = new FormaPagoICBS();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(monedaICBS);
        vlc.add(tipoOpICBS);
        vlc.add(formaPagoICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS monedaICBS;
    private TipoOperacionContableICBS tipoOpICBS;
    private FormaPagoICBS formaPagoICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreTipoSalario", textFieldNombre);
        map.put("monedaDefectoFk", monedaICBS);
        map.put("tipoOperacionContableDefectoFk", tipoOpICBS);
        map.put("formaPagoFk", formaPagoICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
