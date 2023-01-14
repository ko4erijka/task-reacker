--liquibase formatted sql

--changeset ko4erijka:create_search_index_by_workloads rollbackSplitStatements:true
--comment: создание индекса
CREATE INDEX workload_search_index
    ON workloads USING btree
    (name);
--rollback DROP INDEX workload_search_index;