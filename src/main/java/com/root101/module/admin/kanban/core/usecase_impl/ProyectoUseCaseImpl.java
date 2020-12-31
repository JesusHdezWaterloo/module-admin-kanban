package com.root101.module.admin.kanban.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.admin.kanban.core.domain.ProyectoDomain;
import com.root101.module.admin.kanban.core.module.KanbanCoreModule;
import com.root101.module.admin.kanban.core.repo_def.ProyectoRepo;
import com.root101.module.admin.kanban.core.usecase_def.ProyectoUseCase;

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
     * @throws Exception
     * @deprecated
     *
    @Override
    @Deprecated
    public void updateRemote(ProyectoDomain proyecto) throws Exception {
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
