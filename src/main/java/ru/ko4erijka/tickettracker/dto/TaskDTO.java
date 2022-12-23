package ru.ko4erijka.tickettracker.dto;

public class TaskDTO {

    private String name;
    private String desc;
    private String priority;
    private String status;
    private String projectId;
    private String authorId;
    private String assigneeId;

    public TaskDTO(String name, String desc, String priority, String status, String projectId, String authorId, String assigneeId) {
        this.name = name;
        this.desc = desc;
        this.priority = priority;
        this.status = status;
        this.projectId = projectId;
        this.authorId = authorId;
        this.assigneeId = assigneeId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

}
