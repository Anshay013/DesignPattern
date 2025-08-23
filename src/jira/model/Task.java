package jira.model;

import jira.manager.TaskDescription;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String taskId;
    private User createdUser;
    private User AssignedUser;
    private Status status;
    private TaskDescription description;

    private Task parent;

    private List<Task> subTasks = new ArrayList<>();

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Status getStatus() {
        return status;
    }

    public TaskDescription getDescription() {
        return description;
    }

    public void setDescription(TaskDescription description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public void setAssignedUser(User assignedUser) {
        AssignedUser = assignedUser;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public String getTaskId() {
        return taskId;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public User getAssignedUser() {
        return AssignedUser;
    }

    public Task getParent() {
        return parent;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void addSubTask(Task task){
        subTasks.add(task);
    }
}
