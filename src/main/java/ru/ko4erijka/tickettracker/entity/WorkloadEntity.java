package ru.ko4erijka.tickettracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "workloads")
public class WorkloadEntity extends BaseEntity{
    @Column
    private String name;
    @Column
    private String authorId;

    public WorkloadEntity(String name, String authorId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.authorId = authorId;
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public WorkloadEntity() {

    }

    public WorkloadEntity(String id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, createdAt, updatedAt);
    }


    public String getName() {
        return name;
    }

    public String getAuthorId() {
        return authorId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
