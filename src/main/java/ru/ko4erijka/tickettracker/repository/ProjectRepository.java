package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ko4erijka.tickettracker.entity.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, String> {
    @Query("SELECT p FROM projects p WHERE UPPER(p.name) LIKE %:name%")
    Page<ProjectEntity> findByName(String name, Pageable pageable);
}
