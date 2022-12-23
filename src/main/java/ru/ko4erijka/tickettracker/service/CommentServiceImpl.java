package ru.ko4erijka.tickettracker.service;

import org.springframework.stereotype.Service;
import ru.ko4erijka.tickettracker.dto.CommentDTO;
import ru.ko4erijka.tickettracker.entity.CommentEntity;
import ru.ko4erijka.tickettracker.repository.CommentRepository;
import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    public CommentDTO save(CommentDTO dto) {
        commentRepository.save(buildEntity(dto));
        return dto;
    }

    private CommentEntity buildEntity(CommentDTO dto){
        return new CommentEntity(dto.getText(), dto.getTaskId(), dto.getAuthorId(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public CommentDTO getById(String id) {
        CommentEntity commentEntity = commentRepository.findById(id).orElse(null);
        if(commentEntity !=null){
            return buildDto(commentEntity);
        }else {
            return null;
        }
    }

    private CommentDTO buildDto(CommentEntity entity){
        return new CommentDTO(entity.getText(), entity.getTaskId(), entity.getAuthorId());
    }

    @Override
    public CommentDTO update(CommentDTO dto, String id) {
        CommentEntity commentEntity = commentRepository.findById(id).orElse(null);
        if(commentEntity !=null){
            commentEntity.setText(dto.getText());
            commentEntity.setTaskId(dto.getTaskId());
            commentEntity.setAuthorId(dto.getAuthorId());
            commentEntity.setUpdatedAt(LocalDateTime.now());
            commentRepository.save(commentEntity);
            return buildDto(commentEntity);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

}