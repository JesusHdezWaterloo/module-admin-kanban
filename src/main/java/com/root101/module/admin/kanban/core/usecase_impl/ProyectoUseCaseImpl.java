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

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.admin.kanban.core.domain.ProyectoDomain;
import com.root101.module.admin.kanban.core.module.KanbanCoreModule;
import com.root101.module.admin.kanban.core.repo_def.ProyectoRepo;
import com.root101.module.admin.kanban.core.usecase_def.ProyectoUseCase;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ProyectoUseCaseImpl extends DefaultCRUDUseCase<ProyectoDomain> implements ProyectoUseCase {

    private final ProyectoRepo repo = KanbanCoreModule.getInstance().getImplementation(ProyectoRepo.class);

    public ProyectoUseCaseImpl() {
        super.setRepo(repo);
    }
    /*
    
    
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
    
    @Override
    public boolean hasRemote(ProyectoDomain proyecto) {
        try {
            //creo el repo, con el .git detras
            Repository localRepo = new FileRepository(proyecto.getUrlLocal() + "\\.git");

            //git para hacer comandos
            Git git = new Git(localRepo);
            return !git.remoteList().call().isEmpty();
        } catch (Exception e) {
        }

        return false;
    }

    /**
     * No funciona, no se ha echo la integracion con git
     *
     * @param proyecto
     * @throws RuntimeException
     * @deprecated
     *
    @Override
    @Deprecated
    public void updateRemote(ProyectoDomain proyecto) throws RuntimeException {
        //creo el repo, con el .git detras
        Repository localRepo = new FileRepository(proyecto.getUrlLocal() + "\\.git");

        //rama actual
        String actualBranch = localRepo.getFullBranch();
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT,
                "Rama actual: " + actualBranch);

        //git para hacer comandos
        Git git = new Git(localRepo);

        //Chequeo si hay ficheros por hacer un commit
        List<DiffEntry> changes = git.diff().call();
        if (!changes.isEmpty()) {
            throw new Exception("No se puede hacer un update ya que hay cambios uncomited. " + changes);
        }

        //lista de las ramas
        List<Ref> branches = git.branchList().call();
        for (Ref b : branches) {

            Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT,
                    "Cambiando a rama: " + b.getName());
            git.checkout().setName(b.getName()).call();

            Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT,
                    "Pull para actualizar local");
            System.out.println();
            git.pull().call();

            Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT,
                    "Push para actualizar remote");
            git.push().setCredentialsProvider(
                    new UsernamePasswordCredentialsProvider(
                            "JesusHdezWaterloo",
                            "A123b456**"
                    )
            ).call();
        }
        /*
        //lista de las tags
        List<Ref> tags = git.tagList().call();
        for (Ref t : tags) {

            System.out.println("Cambiando a tag: " + t.getName());
            git.checkout().setName(t.getName()).call();

            System.out.println("Push para actualizar remote");
            git.push().setCredentialsProvider(
                    new UsernamePasswordCredentialsProvider(
                            "JesusHdezWaterloo",
                            "A123b456**"
                    )
            ).call();
        }*
        //regreso a la rama original
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT,
                "Checkout para la rama original: " + actualBranch);
        git.checkout().setName(actualBranch).call();
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SUCCESS,
                "Actualizadas todas las ramas con el/los repos online");
    }*/
}
