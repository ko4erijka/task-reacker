--liquibase formatted sql

--changeset ko4erijka:create_search_index_by_tasks rollbackSplitStatements:true
--comment: создание индекса
CREATE INDEX task_search_index
    ON tasks USING btree
    (name);
--rollback DROP INDEX task_search_index;