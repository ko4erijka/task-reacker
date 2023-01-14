package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ko4erijka.tickettracker.entity.CommentEntity;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, String> {
}
