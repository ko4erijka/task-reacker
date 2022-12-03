package ru.ko4erijka.tickettracker.service;


import ru.ko4erijka.tickettracker.dto.WorkloadDTO;

public interface WorkloadService {
    WorkloadDTO getById(String id);
    WorkloadDTO save(WorkloadDTO dto);
    WorkloadDTO update(WorkloadDTO dto,String id);
    WorkloadDTO deleteById(String id);
}
