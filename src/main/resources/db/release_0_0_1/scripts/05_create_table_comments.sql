--liquibase formatted sql

--changeset ko4erijka:create_table_comments rollbackSplitStatements:true
--comment: Создание таблицы комментариев
CREATE TABLE COMMENTS
(
    ID   VARCHAR(36) PRIMARY KEY,
    TEXT VARCHAR(128),
    AUTHOR_ID VARCHAR(36),
    TASK_ID VARCHAR(36),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP

);

COMMENT ON TABLE PROJECTS IS 'Проекты';
COMMENT ON COLUMN PROJECTS.ID IS 'Идентификатор';
COMMENT ON COLUMN PROJECTS.TEXT IS 'Комментарий';
COMMENT ON COLUMN PROJECTS.TASK_ID IS 'Идентификатор задания';
COMMENT ON COLUMN PROJECTS.AUTHOR_ID IS 'Идентификатор автора';
COMMENT ON COLUMN PROJECTS.CREATED_AT IS 'Дата создания';
COMMENT ON COLUMN PROJECTS.UPDATED_AT IS 'Дата обновления';

--rollback DROP TABLE COMMENTS;