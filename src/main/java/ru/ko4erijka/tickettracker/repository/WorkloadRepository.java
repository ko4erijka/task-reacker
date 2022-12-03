package ru.ko4erijka.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ko4erijka.tickettracker.dto.WorkloadDTO;
import ru.ko4erijka.tickettracker.entity.WorkloadEntity;

import java.util.Optional;

@Repository
public interface WorkloadRepository extends JpaRepository<WorkloadEntity, String> {



}
