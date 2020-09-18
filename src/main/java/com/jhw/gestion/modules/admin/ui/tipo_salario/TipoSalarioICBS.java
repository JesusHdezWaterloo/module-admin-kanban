package com.jhw.gestion.modules.admin.ui.tipo_salario;

import com.jhw.gestion.modules.admin.core.domain.TipoSalarioDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaModuleNavigator;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import java.awt.event.ActionListener;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoSalarioICBS extends InputComboBoxSelection<TipoSalarioDomain> {

    public TipoSalarioICBS() {
        super("Tipo Salario");
        setIcon(NominaModuleNavigator.ICON_TIPO_SALARIO);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(NominaSwingModule.tipoSalarioUC.findAll());
    }

    @Override
    public ActionListener buttonAddAction() {
        return new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAddActionPerformed();
            }
        };
    }

    private void onButtonAddActionPerformed() {
        new DialogInputCBS(this, TipoSalarioInputView.from());
    }

}
