package ru.ko4erijka.tickettracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    @NotNull
    @Size(max = 128)
    private String name;
    @NotNull
    @Size(max = 128)
    private String authorId;
    @NotNull
    @Size(max = 128)
    private String desc;
    @NotNull
    @Size(max = 128)
    private String workloadId;

}
