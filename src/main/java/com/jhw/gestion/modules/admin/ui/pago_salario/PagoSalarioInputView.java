package com.jhw.gestion.modules.admin.ui.pago_salario;

import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.DocNombreUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.FechaDescUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.DocNombreInputView;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.FechaDescInputView;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.OperacionCuadreInputView;
import com.jhw.gestion.modules.admin.core.domain.ContratoEmpleadoDomain;
import com.jhw.gestion.modules.admin.core.domain.PagoSalarioDomain;
import com.jhw.gestion.modules.admin.core.domain.TipoSalarioDomain;
import com.jhw.gestion.modules.admin.core.usecase_impl.ColumnaUseCaseImpl;
import com.jhw.gestion.modules.admin.ui.contrato_empleado.ContratoEmpleadoICBS;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import com.jhw.gestion.modules.admin.ui.tipo_salario.TipoSalarioICBS;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Date;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PagoSalarioInputView extends CleanCRUDInputView<PagoSalarioDomain> {

    public static PagoSalarioInputView from() {
        return new PagoSalarioInputView(null);
    }

    public static PagoSalarioInputView fromModel(PagoSalarioDomain model) {
        return new PagoSalarioInputView(model);
    }

    public static PagoSalarioInputView fromBase(TipoSalarioDomain tipo) {
        PagoSalarioInputView thiss = new PagoSalarioInputView(null);
        thiss.setTipoSalario(tipo);
        return thiss;
    }

    private PagoSalarioInputView(PagoSalarioDomain model) {
        super(model, NominaSwingModule.pagoSalarioUC, PagoSalarioDomain.class);
        initComponents();
        addListener();
        update();
    }

    private void initComponents() {
        //doc, nombre ....
        docNombreInputView = DocNombreInputView.from();

        //valor, cuentas ....
        operacionInputView = OperacionCuadreInputView.fromTipoOp(ColumnaUseCaseImpl.ESTIMULACION.getTipoOperacionContableDefectoFk());

        //tipo gasto
        tipoSalarioICBS = new TipoSalarioICBS();

        //fecha, desc ....
        fechaDescInputView = FechaDescInputView.from();

        //empleado
        cttoEmpleadoICBS = new ContratoEmpleadoICBS();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(400);
        vlc.add(docNombreInputView);
        vlc.add(cttoEmpleadoICBS);
        vlc.add(operacionInputView);
        vlc.add(tipoSalarioICBS);
        vlc.add(fechaDescInputView, true);

        this.setComponent(vlc.build());

        operacionInputView.getTipoOperICBS().setEnabled(false);
    }

    // Variables declaration - do not modify
    private ContratoEmpleadoICBS cttoEmpleadoICBS;
    private DocNombreInputView docNombreInputView;
    private OperacionCuadreInputView operacionInputView;
    private TipoSalarioICBS tipoSalarioICBS;
    private FechaDescInputView fechaDescInputView;
    // End of variables declaration

    @Override
    public void update() {
        tipoSalarioICBS.update();
        cttoEmpleadoICBS.update();
        if (getOldModel() == null) {
            setHeader("Crear Pago de Salario");
        } else {
            setHeader("Editar Pago de Salario");
            docNombreInputView.setObject(new DocNombreUI(getOldModel().getCuadreFk().info()));
            fechaDescInputView.setObject(new FechaDescUI(getOldModel().getCuadreFk().info()));

            operacionInputView.setObject(new OperacionCuadreUI(getOldModel().getCuadreFk()));
            operacionInputView.getMoneda().setObject(getOldModel().getMonedaFk());
            operacionInputView.getTextFieldValor().setObject(getOldModel().getValor());
        }
    }

    @Override
    public PagoSalarioDomain getNewModel() throws Exception {
        DocNombreUI docNombre = docNombreInputView.getNewModel();
        OperacionCuadreUI op = operacionInputView.getNewModel();
        FechaDescUI fechaDesc = fechaDescInputView.getNewModel();
        TipoSalarioDomain tipoGasto = tipoSalarioICBS.getObject();
        ContratoEmpleadoDomain ctto_empleado = cttoEmpleadoICBS.getObject();

        CuadreUI cuadre = new CuadreUI(docNombre, op, fechaDesc);

        PagoSalarioDomain neww = new PagoSalarioDomain(op.getValor(), op.getMoneda(), cuadre.buildCuadre(), tipoGasto, ctto_empleado);

        if (getOldModel() != null) {
            neww.setIdPagoSalario(getOldModel().getIdPagoSalario());
            neww.getCuadreFk().setIdCuadre(getOldModel().getCuadreFk().getIdCuadre());
        }
        return neww;
    }

    private void addListener() {
        tipoSalarioICBS.getComboBox().addActionListener((java.awt.event.ActionEvent evt) -> {
            onTipoSalarioComboBoxActionPerformed();
        });
    }

    private void onTipoSalarioComboBoxActionPerformed() {
        try {
            setTipoSalario(tipoSalarioICBS.getObject());
        } catch (Exception e) {
        }
    }

    private void setTipoSalario(TipoSalarioDomain tipo) {
        fechaDescInputView.setObject(new FechaDescUI(new Date(), tipo.getFormaPagoFk(), tipo.getDescripcion()));
        docNombreInputView.setObject(new DocNombreUI("Pago de " + tipo.getNombreTipoSalario(), ""));

        operacionInputView.getMoneda().setObject(tipo.getMonedaDefectoFk());

        operacionInputView.setTipoOp(tipo.getTipoOperacionContableDefectoFk());

        tipoSalarioICBS.setObject(tipo);
    }

}
