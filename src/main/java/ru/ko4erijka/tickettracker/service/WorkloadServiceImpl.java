package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ko4erijka.tickettracker.dto.WorkloadDTO;
import ru.ko4erijka.tickettracker.entity.WorkloadEntity;
import ru.ko4erijka.tickettracker.repository.WorkloadRepository;

import java.time.LocalDateTime;

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
    public void deleteById(String id) {
        workloadRepository.deleteById(id);
    }

    @Override
    public Page<WorkloadDTO> getAll(Integer pageSize, Integer pageNumber) {
       Page<WorkloadEntity> workloadsEntity = workloadRepository.findAll(Pageable
                .ofSize(pageSize)
                .withPage(pageNumber));
        return workloadsEntity.map(this::buildDto);

    }


}
