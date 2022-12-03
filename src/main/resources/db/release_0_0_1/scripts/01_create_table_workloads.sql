--liquibase formatted sql

--changeset ko4erijka:create_table_workloads rollbackSplitStatements:true
--comment: Создание таблицы рабочих пространств
CREATE TABLE WORKLOADS
(
    ID   VARCHAR(36) PRIMARY KEY,
    NAME VARCHAR(128),
    AUTHOR_ID VARCHAR(36),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);

COMMENT ON TABLE WORKLOADS IS 'Рабочие пространства';
COMMENT ON COLUMN WORKLOADS.ID IS 'Идентификатор';
COMMENT ON COLUMN WORKLOADS.NAME IS 'Наименование';
COMMENT ON COLUMN WORKLOADS.AUTHOR_ID IS 'Идентификатор автора';
COMMENT ON COLUMN WORKLOADS.CREATED_AT IS 'Дата создания';
COMMENT ON COLUMN WORKLOADS.UPDATED_AT IS 'Дата обновления';

--rollback DROP TABLE WORKLOADS;