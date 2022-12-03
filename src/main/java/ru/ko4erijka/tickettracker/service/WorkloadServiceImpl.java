package ru.ko4erijka.tickettracker.service;

import org.springframework.stereotype.Service;
import ru.ko4erijka.tickettracker.dto.WorkloadDTO;
import ru.ko4erijka.tickettracker.entity.WorkloadEntity;
import ru.ko4erijka.tickettracker.repository.WorkloadRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WorkloadServiceImpl implements WorkloadService{

    private final WorkloadRepository workloadRepository;

    public WorkloadServiceImpl(WorkloadRepository workloadRepository) {
        this.workloadRepository = workloadRepository;
    }

    @Override
    public WorkloadDTO save(WorkloadDTO dto) {
        workloadRepository.save(buildEntity(dto));
        return dto;
    }

    private WorkloadEntity buildEntity(WorkloadDTO dto){
      return new WorkloadEntity(dto.getName(),dto.getAuthorId(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public WorkloadDTO getById(String id) {
        WorkloadEntity workloadEntity = workloadRepository.findById(id).orElse(null);
        if(workloadEntity !=null){
            return buildDto(workloadEntity);
        }else {
            return null;
        }
    }

    private WorkloadDTO buildDto(WorkloadEntity entity){
        return new WorkloadDTO(entity.getName(),entity.getAuthorId());
    }

    @Override
    public WorkloadDTO update(WorkloadDTO dto, String id) {
        WorkloadEntity workloadEntity = workloadRepository.findById(id).orElse(null);
        if(workloadEntity !=null){
            workloadEntity.setName(dto.getName());
            workloadEntity.setAuthorId(dto.getAuthorId());
            workloadEntity.setUpdatedAt(LocalDateTime.now());
            workloadRepository.save(workloadEntity);
            return buildDto(workloadEntity);
        }else {
            return null;
        }
    }

    @Override
    public WorkloadDTO deleteById(String id) {
       return null;//не понял как написать
    }


}
