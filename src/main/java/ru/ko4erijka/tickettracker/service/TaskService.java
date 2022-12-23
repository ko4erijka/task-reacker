package ru.ko4erijka.tickettracker.service;

import ru.ko4erijka.tickettracker.dto.TaskDTO;

public interface TaskService {
    TaskDTO save(TaskDTO dto);
    TaskDTO getById(String id);

    TaskDTO update(TaskDTO dto, String id);

    void deleteById(String id);
}
