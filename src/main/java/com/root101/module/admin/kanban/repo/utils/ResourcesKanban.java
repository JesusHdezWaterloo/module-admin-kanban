/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.admin.kanban.repo.utils;

import com.jhw.module.util.mysql.services.MySQLHandler;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ResourcesKanban {

    public static final String SCHEMA = "admin_kanban";
            
    public static EntityManagerFactory EMF;

    public static void initEMF() {
        try {
            EMF = Persistence.createEntityManagerFactory("KanbanPU", MySQLHandler.propertiesMap(SCHEMA));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
