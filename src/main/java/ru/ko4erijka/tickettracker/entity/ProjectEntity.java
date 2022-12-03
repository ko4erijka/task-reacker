package ru.ko4erijka.tickettracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "projects")
public class ProjectEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column
    private String name;
    @Column
    private String desc;
    @Column
    private String workloadId;
    @Column
    private String authorId;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    public ProjectEntity(String name, String desc, String workloadId, String authorId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.desc = desc;
        this.workloadId = workloadId;
        this.authorId = authorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ProjectEntity() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getWorkloadId() {
        return workloadId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setWorkloadId(String workloadId) {
        this.workloadId = workloadId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
