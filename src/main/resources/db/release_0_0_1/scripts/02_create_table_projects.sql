--liquibase formatted sql

--changeset ko4erijka:create_table_projects rollbackSplitStatements:true
--comment: Создание таблицы проектов
CREATE TABLE PROJECTS
(
    ID   VARCHAR(36) PRIMARY KEY,
    NAME VARCHAR(128),
    DESC VARCHAR(36),
    WORKLOAD_ID VARCHAR(36),
    AUTHOR_ID VARCHAR(36),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);

COMMENT ON TABLE PROJECTS IS 'Проекты';
COMMENT ON COLUMN PROJECTS.ID IS 'Идентификатор';
COMMENT ON COLUMN PROJECTS.NAME IS 'Наименование';
COMMENT ON COLUMN PROJECTS.DESC IS 'Описание проекта';
COMMENT ON COLUMN PROJECTS.WORKLOAD_ID IS 'Идентификатор рабочего пространства';
COMMENT ON COLUMN PROJECTS.AUTHOR_ID IS 'Идентификатор автора';
COMMENT ON COLUMN PROJECTS.CREATED_AT IS 'Дата создания';
COMMENT ON COLUMN PROJECTS.UPDATED_AT IS 'Дата обновления';

--rollback DROP TABLE PROJECTS;