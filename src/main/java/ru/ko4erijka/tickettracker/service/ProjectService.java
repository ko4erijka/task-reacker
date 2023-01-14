package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import ru.ko4erijka.tickettracker.dto.ProjectDTO;

public interface ProjectService {
    ProjectDTO save(ProjectDTO dto);
    ProjectDTO getById(String id);
    ProjectDTO update(ProjectDTO dto, String id);
    void deleteById(String id);
    Page<ProjectDTO> find(String name, Integer pageSize, Integer pageNumber);

    Page<ProjectDTO> getAll(Integer pageSize, Integer pageNumber);
}
