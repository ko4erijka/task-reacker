package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import ru.ko4erijka.tickettracker.dto.TaskDTO;

public interface TaskService {
    TaskDTO save(TaskDTO dto);
    TaskDTO getById(String id);

    TaskDTO update(TaskDTO dto, String id);

    void deleteById(String id);
    Page<TaskDTO> getAll(Integer pageSize, Integer pageNumber);
    Page<TaskDTO> find(String name, Integer pageSize, Integer pageNumber);
}
