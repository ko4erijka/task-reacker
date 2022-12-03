package ru.ko4erijka.tickettracker.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ko4erijka.tickettracker.dto.WorkloadDTO;
import ru.ko4erijka.tickettracker.service.WorkloadService;

@RestController
@RequestMapping(value = "/api/workload",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class WorkloadController {

    private final WorkloadService workloadService;

    public WorkloadController(WorkloadService workloadService) {
        this.workloadService = workloadService;
    }

    @PostMapping
    public ResponseEntity<WorkloadDTO> save(@RequestBody WorkloadDTO dto){
        WorkloadDTO workloadRs = workloadService.save(dto);
        return ResponseEntity.ok(workloadRs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkloadDTO> get(@PathVariable String id){
        WorkloadDTO workload = workloadService.getById(id);
        return ResponseEntity.ok(workload);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkloadDTO> update(@RequestBody WorkloadDTO dto,@PathVariable String id){
        WorkloadDTO workloadDTO = workloadService.update(dto, id);
        return ResponseEntity.ok(workloadDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkloadDTO> delete(@PathVariable String id){
        WorkloadDTO workloadDtoDel = workloadService.deleteById(id);
        return ResponseEntity.ok(workloadDtoDel);
    }
}
