package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ko4erijka.tickettracker.entity.LabelEntity;


public interface LabelRepository extends JpaRepository<LabelEntity, String> {
}
