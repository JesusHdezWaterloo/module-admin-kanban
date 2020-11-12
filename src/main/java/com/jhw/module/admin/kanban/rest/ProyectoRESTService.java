/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.kanban.rest;

import static com.jhw.module.admin.kanban.core.ModuleAdminKanbanConstants.*;
import com.jhw.module.admin.kanban.core.domain.*;
import com.jhw.module.admin.kanban.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = PROYECTO_GENERAL_PATH)
public class ProyectoRESTService extends RESTServiceTemplate<ProyectoDomain> implements ProyectoUseCase {

    private final ProyectoUseCase proyectoUC = A_ModuleAdminKanbanEmpresarial.proyectoUC;

    public ProyectoRESTService() {
        setUseCase(proyectoUC);
    }

}
