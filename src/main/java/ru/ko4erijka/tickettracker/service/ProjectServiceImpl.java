package ru.ko4erijka.tickettracker.service;

import org.springframework.stereotype.Service;
import ru.ko4erijka.tickettracker.dto.ProjectDTO;
import ru.ko4erijka.tickettracker.entity.ProjectEntity;
import ru.ko4erijka.tickettracker.repository.ProjectRepository;
import java.time.LocalDateTime;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;


    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDTO save(ProjectDTO dto) {
        projectRepository.save(buildEntity(dto));
        return dto;
    }

    @Override
    public ProjectDTO getById(String id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElse(null);
        if(projectEntity !=null){
            return buildDto(projectEntity);
        }else {
            return null;
        }
    }

    private ProjectDTO buildDto(ProjectEntity entity){
        return new ProjectDTO(entity.getName(), entity.getDesc(), entity.getWorkloadId(), entity.getAuthorId());
    }
    private ProjectEntity buildEntity(ProjectDTO dto){
        return new ProjectEntity(dto.getName(),dto.getDesc(),dto.getWorkloadId(), dto.getAuthorId(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public ProjectDTO update(ProjectDTO dto, String id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElse(null);
        if(projectEntity !=null){
            projectEntity.setName(dto.getName());
            projectEntity.setDesc(dto.getDesc());
            projectEntity.setWorkloadId(dto.getWorkloadId());
            projectEntity.setAuthorId(dto.getAuthorId());
            projectEntity.setUpdatedAt(LocalDateTime.now());
            projectRepository.save(projectEntity);
            return buildDto(projectEntity);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        projectRepository.deleteById(id);
    }
}
