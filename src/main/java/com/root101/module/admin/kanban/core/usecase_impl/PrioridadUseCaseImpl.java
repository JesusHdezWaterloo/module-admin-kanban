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
package com.root101.module.admin.kanban.core.usecase_impl;

import com.root101.module.admin.kanban.core.domain.PrioridadDomain;
import com.root101.module.admin.kanban.core.usecase_def.PrioridadUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.admin.kanban.core.module.KanbanCoreModule;
import com.root101.module.admin.kanban.core.repo_def.PrioridadRepo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class PrioridadUseCaseImpl extends DefaultCRUDUseCase<PrioridadDomain> implements PrioridadUseCase {

    private final PrioridadRepo repo = KanbanCoreModule.getInstance().getImplementation(PrioridadRepo.class);

    public PrioridadUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<PrioridadDomain> findAll(String searchText) throws RuntimeException {
        List<PrioridadDomain> all = findAll();
        List<PrioridadDomain> filter = new ArrayList<>();
        for (PrioridadDomain p : all) {
            if (p.test(searchText)) {
                filter.add(p);
            }
        }
        return filter;
    }

}
