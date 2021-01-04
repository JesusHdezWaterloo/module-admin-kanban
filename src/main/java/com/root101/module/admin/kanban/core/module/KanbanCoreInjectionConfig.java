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
package com.root101.module.admin.kanban.core.module;

import com.google.inject.Singleton;
import com.root101.module.admin.kanban.core.usecase_def.ColumnaUseCase;
import com.root101.module.admin.kanban.core.usecase_def.PrioridadUseCase;
import com.root101.module.admin.kanban.core.usecase_def.ProyectoUseCase;
import com.root101.module.admin.kanban.core.usecase_def.TareaUseCase;
import com.root101.module.admin.kanban.core.usecase_impl.ColumnaUseCaseImpl;
import com.root101.module.admin.kanban.core.usecase_impl.PrioridadUseCaseImpl;
import com.root101.module.admin.kanban.core.usecase_impl.ProyectoUseCaseImpl;
import com.root101.module.admin.kanban.core.usecase_impl.TareaUseCaseImpl;
import com.root101.module.control.licence.core.injection.LicenceInjectionConfig;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class KanbanCoreInjectionConfig extends LicenceInjectionConfig {

    @Override
    protected void configure() {
        super.configure();//configura la licencia
        
        bind(ColumnaUseCase.class).to(ColumnaUseCaseImpl.class).in(Singleton.class);
        bind(PrioridadUseCase.class).to(PrioridadUseCaseImpl.class).in(Singleton.class);
        bind(ProyectoUseCase.class).to(ProyectoUseCaseImpl.class).in(Singleton.class);
        bind(TareaUseCase.class).to(TareaUseCaseImpl.class).in(Singleton.class);
    }

}
