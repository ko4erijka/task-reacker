--liquibase formatted sql

--changeset ko4erijka:create_search_index_by_projects rollbackSplitStatements:true
--comment: создание индекса
CREATE INDEX project_search_index
    ON projects USING btree
    (name);
--rollback DROP INDEX project_search_index;