package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ko4erijka.tickettracker.dto.LabelDTO;
import ru.ko4erijka.tickettracker.entity.LabelEntity;
import ru.ko4erijka.tickettracker.repository.LabelRepository;

import java.time.LocalDateTime;

@Service
public class LabelServiceImpl implements LabelService{
    private final LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public LabelDTO save(LabelDTO dto) {
        labelRepository.save(buildEntity(dto));
        return dto;
    }

    private LabelEntity buildEntity(LabelDTO dto){
        return new LabelEntity(dto.getLabel(), dto.getTaskId(), dto.getAuthorId(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public LabelDTO getById(String id) {
        LabelEntity labelEntity = labelRepository.findById(id).orElse(null);
        if(labelEntity !=null){
            return buildDto(labelEntity);
        }else {
            return null;
        }
    }

    private LabelDTO buildDto(LabelEntity entity){
        return new LabelDTO(entity.getLabel(), entity.getTaskId(), entity.getAuthorId());
    }

    @Override
    public LabelDTO update(LabelDTO dto, String id) {
        LabelEntity labelEntity = labelRepository.findById(id).orElse(null);
        if(labelEntity !=null){
            labelEntity.setLabel(dto.getLabel());
            labelEntity.setTaskId(dto.getTaskId());
            labelEntity.setAuthorId(dto.getAuthorId());
            labelEntity.setUpdatedAt(LocalDateTime.now());
            labelRepository.save(labelEntity);
            return buildDto(labelEntity);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        labelRepository.deleteById(id);
    }

    @Override
    public Page<LabelDTO> getAll(Integer pageSize, Integer pageNumber) {
        Page<LabelEntity> labelEntity = labelRepository.findAll(Pageable
                .ofSize(pageSize)
                .withPage(pageNumber));
        return labelEntity.map(this::buildDto);
    }

}