--liquibase formatted sql

--changeset ko4erijka:create_table_tasks rollbackSplitStatements:true
--comment: Создание таблицы заданий
CREATE TABLE TASKS
(
    ID   VARCHAR(36) PRIMARY KEY,
    NAME VARCHAR(128),
    DESC VARCHAR(36),
    PRIORITY VARCHAR(36),
    STATUS VARCHAR(36),
    AUTHOR_ID VARCHAR(36),
    PROJECT_ID VARCHAR(36),
    ASSIGNEE_ID VARCHAR(36),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);

COMMENT ON TABLE PROJECTS IS 'Задания';
COMMENT ON COLUMN PROJECTS.ID IS 'Идентификатор';
COMMENT ON COLUMN PROJECTS.NAME IS 'Наименование';
COMMENT ON COLUMN PROJECTS.DESC IS 'Описание задания';
COMMENT ON COLUMN PROJECTS.AUTHOR_ID IS 'Идентификатор автора';
COMMENT ON COLUMN PROJECTS.PRIORITY IS 'Приоритет задания';
COMMENT ON COLUMN PROJECTS.STATUS IS 'Статус задания';
COMMENT ON COLUMN PROJECTS.PROJECT_ID IS 'Идентификатор проекта';
COMMENT ON COLUMN PROJECTS.ASSIGNEE_ID IS 'Идентификатор ответственного за задание';
COMMENT ON COLUMN PROJECTS.CREATED_AT IS 'Дата создания';
COMMENT ON COLUMN PROJECTS.UPDATED_AT IS 'Дата обновления';

--rollback DROP TABLE TASKS;