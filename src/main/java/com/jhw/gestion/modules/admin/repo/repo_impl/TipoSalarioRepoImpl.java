package com.jhw.gestion.modules.admin.repo.repo_impl;

import com.jhw.gestion.modules.admin.repo.utils.ResourcesKanban;
import com.jhw.utils.services.ConverterService;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import javax.persistence.EntityManager;

public class TipoSalarioRepoImpl extends JPACleanCRUDRepo<TipoSalarioDomain, TipoSalario> implements TipoSalarioRepo {

    public TipoSalarioRepoImpl() {
        super(ResourcesKanban.EMF, TipoSalarioDomain.class, TipoSalario.class);
    }

    @Override
    public TipoSalarioDomain findByKey(String key) throws Exception {
        EntityManager em = getEntityManager();
        try {
            TipoSalario obj = em.createNamedQuery("TipoSalario.findByKeyEnum", TipoSalario.class).setParameter("keyEnum", key).getSingleResult();
            return ConverterService.convert(obj, TipoSalarioDomain.class);
        } finally {
            em.close();
        }
    }
}
