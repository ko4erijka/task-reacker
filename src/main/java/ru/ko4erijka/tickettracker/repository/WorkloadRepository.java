package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ko4erijka.tickettracker.entity.WorkloadEntity;

@Repository
public interface WorkloadRepository extends JpaRepository<WorkloadEntity, String> {
    @Query("SELECT p FROM workloads p WHERE UPPER(p.name) LIKE %:name%")
    Page<WorkloadEntity> findByName(String name, Pageable pageable);
}
