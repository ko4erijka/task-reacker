package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ko4erijka.tickettracker.entity.TaskEntity;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    @Query("SELECT p FROM tasks p WHERE UPPER(p.name) LIKE %:name%")
    Page<TaskEntity> findByName(String name, Pageable pageable);
}
