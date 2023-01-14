package ru.ko4erijka.tickettracker.service;


import org.springframework.data.domain.Page;
import ru.ko4erijka.tickettracker.dto.WorkloadDTO;

public interface WorkloadService {
    WorkloadDTO getById(String id);
    WorkloadDTO save(WorkloadDTO dto);
    WorkloadDTO update(WorkloadDTO dto,String id);
    void deleteById(String id);
    Page<WorkloadDTO> getAll(Integer pageSize, Integer pageNumber);

    Page<WorkloadDTO> find(String name, Integer pageSize, Integer pageNumber);
}
