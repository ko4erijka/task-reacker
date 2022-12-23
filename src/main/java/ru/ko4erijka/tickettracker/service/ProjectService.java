package ru.ko4erijka.tickettracker.service;

import ru.ko4erijka.tickettracker.dto.ProjectDTO;

public interface ProjectService {
    ProjectDTO save(ProjectDTO dto);
    ProjectDTO getById(String id);

    ProjectDTO update(ProjectDTO dto, String id);

    void deleteById(String id);
}
