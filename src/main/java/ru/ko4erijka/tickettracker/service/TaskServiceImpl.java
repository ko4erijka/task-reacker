package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ko4erijka.tickettracker.dto.TaskDTO;
import ru.ko4erijka.tickettracker.entity.TaskEntity;
import ru.ko4erijka.tickettracker.repository.TaskRepository;
import java.time.LocalDateTime;
@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO save(TaskDTO dto) {
        taskRepository.save(buildEntity(dto));
        return dto;
    }

    private TaskEntity buildEntity(TaskDTO dto){
        return new TaskEntity(dto.getName(),dto.getDesc(), dto.getPriority(), dto.getStatus(), dto.getProjectId(), dto.getAuthorId(), dto.getAssigneeId(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public TaskDTO getById(String id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElse(null);
        if(taskEntity !=null){
            return buildDto(taskEntity);
        }else {
            return null;
        }
    }

    private TaskDTO buildDto(TaskEntity entity){
        return new TaskDTO(entity.getName(),entity.getDesc(),entity.getPriority(),entity.getStatus(),entity.getProjectId(),entity.getAuthorId(), entity.getAssigneeId());
    }

    @Override
    public TaskDTO update(TaskDTO dto, String id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElse(null);
        if(taskEntity !=null){
            taskEntity.setName(dto.getName());
            taskEntity.setDesc(dto.getDesc());
            taskEntity.setPriority(dto.getPriority());
            taskEntity.setStatus(dto.getStatus());
            taskEntity.setProjectId(dto.getProjectId());
            taskEntity.setAssigneeId(dto.getAssigneeId());
            taskEntity.setAuthorId(dto.getAuthorId());
            taskEntity.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(taskEntity);
            return buildDto(taskEntity);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Page<TaskDTO> getAll(Integer pageSize, Integer pageNumber) {
        Page<TaskEntity> taskEntity = taskRepository.findAll(Pageable
                .ofSize(pageSize)
                .withPage(pageNumber));
        return taskEntity.map(this::buildDto);
    }

    @Override
    public Page<TaskDTO> find(String name, Integer pageSize, Integer pageNumber) {
        Page<TaskEntity> taskEntity = taskRepository.findByName(name, Pageable
                .ofSize(pageSize)
                .withPage(pageNumber));
        return taskEntity.map(this::buildDto);
    }

}
