package ru.ko4erijka.tickettracker.dto;

public class ProjectDTO {
    private String name;
    private String authorId;
    private String desc;
    private String workloadId;
    public ProjectDTO(String name, String authorId, String desc, String workloadId) {
        this.name = name;
        this.authorId = authorId;
        this.desc = desc;
        this.workloadId = workloadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getWorkloadId() {
        return workloadId;
    }

    public void setWorkloadId(String workloadId) {
        this.workloadId = workloadId;
    }
}
