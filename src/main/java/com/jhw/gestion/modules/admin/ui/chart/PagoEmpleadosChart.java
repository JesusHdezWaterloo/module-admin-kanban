package com.jhw.gestion.modules.admin.ui.chart;

import com.clean.core.app.services.ExceptionHandler;
import com.jaga.swing.chart._MaterialBarChart;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.admin.core.domain.EmpleadoDomain;
import com.jhw.gestion.modules.admin.ui.module.NominaSwingModule;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PagoEmpleadosChart extends _MaterialBarChart implements Update {

    public PagoEmpleadosChart() {
        addCategory("Pago Salario", MaterialColors.AMBERA_700);
        update();
    }

    @Override
    public void update() {
        removeAllBars();
        try {
            HashMap<EmpleadoDomain, BigDecimal> h = NominaSwingModule.pagoSalarioUC.reporteSalarioPorEmpleado();
            for (Map.Entry<EmpleadoDomain, BigDecimal> entry : h.entrySet()) {
                addBar(entry.getValue(), 0, entry.getKey().getNombreEmpleado());
            }
            this.getChart().setTitle("Salarios a los Empleados (Conversión a: " + MonedaHandler.getMonedaBase() + ")");
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }

    }

}
