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

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ModuleAdminKanbanRESTConstants {

    public static final String KANBAN_GENERAL_PATH = "/kanban";

    public static final String SEARCH = "search";
    public static final String COL_PROY = "columna_proyecto";
    public static final String TAREA = "tarea";
    public static final String COLUMNA = "columna";
    public static final String PROYECTO = "proyecto";

    //-----------------------COLUMNS-----------------------\\
    public static final String COLUMMA_GENERAL_PATH = KANBAN_GENERAL_PATH + "/columna";

    public static final String COLUMNA_FIND_FIRST_PATH = "/first";
    public static final RequestMethod COLUMNA_FIND_FIRST_METHOD = RequestMethod.GET;

    public static final String COLUMNA_FIND_LAST_PATH = "/last";
    public static final RequestMethod COLUMNA_FIND_LAST_METHOD = RequestMethod.GET;

    //-----------------------PRIORIDAD-----------------------\\
    public static final String PRIORIDAD_GENERAL_PATH = KANBAN_GENERAL_PATH + "/prioridad";

    public static final String PRIORIDAD_FIND_ALL_SEARCH_PATH = "/find_all/{" + SEARCH + "}";
    public static final RequestMethod PRIORIDAD_FIND_ALL_SEARCH_METHOD = RequestMethod.GET;

    //-----------------------PROYECTO-----------------------\\
    public static final String PROYECTO_GENERAL_PATH = KANBAN_GENERAL_PATH + "/proyecto";

    //-----------------------TAREA-----------------------\\
    public static final String TAREA_GENERAL_PATH = KANBAN_GENERAL_PATH + "/tarea";

    public static final String TAREA_FIND_BY_COL_PROY_PATH = "/find/{" + PROYECTO + "}/{" + COLUMNA + "}";
    public static final RequestMethod TAREA_FIND_BY_COL_PROY_METHOD = RequestMethod.GET;

    public static final String TAREA_MOVE_PATH = "/move";
    public static final RequestMethod TAREA_MOVE_METHOD = RequestMethod.GET;

}
