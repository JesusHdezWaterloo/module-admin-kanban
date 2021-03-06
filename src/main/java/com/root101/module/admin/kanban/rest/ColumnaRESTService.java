/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.kanban.rest;

import com.root101.spring.server.RESTServiceTemplate;
import static com.root101.module.admin.kanban.rest.ModuleAdminKanbanRESTConstants.*;
import com.root101.module.admin.kanban.core.domain.*;
import com.root101.module.admin.kanban.core.usecase_def.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@RestController
@RequestMapping(value = COLUMMA_GENERAL_PATH)
public class ColumnaRESTService extends RESTServiceTemplate<ColumnaDomain> implements ColumnaUseCase {

    private final ColumnaUseCase columnsUC = A_ModuleAdminKanbanRESTConfig.columnsUC;

    public ColumnaRESTService() {
        setUseCase(columnsUC);
    }

    @Override
    @GetMapping(COLUMNA_FIND_FIRST_PATH)
    public ColumnaDomain findFirst() throws RuntimeException {
        return columnsUC.findFirst();
    }

    @Override
    @GetMapping(COLUMNA_FIND_LAST_PATH)
    public ColumnaDomain findLast() throws RuntimeException {
        return columnsUC.findLast();
    }

}
