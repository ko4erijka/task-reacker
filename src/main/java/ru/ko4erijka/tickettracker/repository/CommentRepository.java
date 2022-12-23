package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ko4erijka.tickettracker.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {
}
