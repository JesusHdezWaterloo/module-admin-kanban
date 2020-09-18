package com.jhw.gestion.modules.admin.ui.pago_salario;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.gestion.modules.admin.core.domain.PagoSalarioDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.utils.others.SDF;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import com.jhw.gestion.modules.admin.ui.module.NominaModuleNavigator;
import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.AbstractActionUtils;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PagoSalarioDetailView extends _MaterialPanelDetail<PagoSalarioDomain> {

    private static final String COL_TRABAJADOR = "Trabajador";
    private static final String COL_VALOR = "Valor";
    private static final String COL_FECHA = "Fecha";
    private static final String COL_TIPO_SALARIO = "Tipo";
    private static final String COL_CUENTA = "Cuenta";

    public PagoSalarioDetailView() {
        super(
                Column.builder().name(COL_TRABAJADOR).build(),
                Column.builder().name(COL_VALOR).build(),
                Column.builder().name(COL_TIPO_SALARIO).build(),
                Column.builder().name(COL_FECHA).build(),
                Column.builder().name(COL_CUENTA).build()
        );

        this.personalize();
    }

    private void personalize() {
        setUpEditorsRenders();

        this.setHeaderText("Salarios");
        this.setIcon(NominaModuleNavigator.ICON_SALARIOS);

        addOptionsElements();
        this.getTableByPage().setPageVisibility(true);
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
        setAdjustColumns(true);
    }

    @Override
    public void update() {
        try {
            setCollection(NominaSwingModule.pagoSalarioUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(PagoSalarioDomain obj) {
        return new Object[]{
            obj.getContratoEmpleadoFk(),
            MoneyTableComponent.from(obj.getValor(), obj.getMonedaFk()),
            obj.getTipoSalarioFk(),
            SDF.SDF.format(obj.getCuadreFk().info().getFecha()),
            obj.getCuadreFk().getOperacionContableFk().getCuentaFk()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, PagoSalarioInputView.from());
    }

    @Override
    protected PagoSalarioDomain deleteAction(PagoSalarioDomain obj) {
        try {
            return NominaSwingModule.pagoSalarioUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(PagoSalarioDomain obj) {
        new DialogModelInput(this, PagoSalarioInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(PagoSalarioDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addOptionsElements() {
        MaterialButton popup = MaterialButtonsFactory.buildPopup(Arrays.asList(
                AbstractActionUtils.from("Empl.", NominaModuleNavigator.ICON_EMPLEADOS, "Gráfico con detalles de los pagos de salarios por empleados.", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onChartEmpleadosOptionActionPerformed();
                    }
                }),
                AbstractActionUtils.from("Puesto", NominaModuleNavigator.ICON_PUESTO_TRABAJO, "Gráfico con detalles de los pagos de salarios por puestos de trabajo.", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onChartPuestosOptionActionPerformed();
                    }
                }),
                AbstractActionUtils.from("Tipo", NominaModuleNavigator.ICON_TIPO_SALARIO, "Gráfico con detalles de los pagos de salarios por tipos de salario.", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onChartTipoSalarioOptionActionPerformed();
                    }
                })
        ));
        popup.setText("Reportes");
        popup.setIconTextGap(10);
        popup.setIcon(MaterialIcons.ASSESSMENT);
        popup.setToolTipText("Reportes relacionados a los pagos de los salarios.");

        addOptionElement(popup);
        /*this.addOptionElement(new AbstractAction("Gráfico con detalles de los pagos de salarios por empleados.", NominaModuleNavigator.ICON_EMPLEADOS.deriveIcon(30f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChartEmpleadosOptionActionPerformed();
            }
        });
        this.addOptionElement(new AbstractAction("Gráfico con detalles de los pagos de salarios por puestos de trabajo.", NominaModuleNavigator.ICON_PUESTO_TRABAJO.deriveIcon(30f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChartPuestosOptionActionPerformed();
            }
        });
        this.addOptionElement(new AbstractAction("Gráfico con detalles de los pagos de salarios por tipos de salario.", NominaModuleNavigator.ICON_TIPO_SALARIO.deriveIcon(30f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChartTipoSalarioOptionActionPerformed();
            }
        });*/
    }

    private void onChartEmpleadosOptionActionPerformed() {
        new DialogPanel("Gráfico de salario por empleados", new PagoEmpleadosChart());
    }

    private void onChartPuestosOptionActionPerformed() {
        new DialogPanel("Gráfico de salario por puestos de trabajo", new PagoPuestosTrabajoChart());
    }

    private void onChartTipoSalarioOptionActionPerformed() {
        new DialogPanel("Gráfico de salario por tipos de salarios", new PagoTipoSalarioChart());
    }

    private void setUpEditorsRenders() {
        getTable().getColumn(COL_VALOR).setCellRenderer(new MoneyCellRender());
    }

}
