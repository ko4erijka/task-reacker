package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ko4erijka.tickettracker.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {
}
