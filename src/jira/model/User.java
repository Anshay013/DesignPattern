package jira.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String UserId;
    private String name;

    private final List<Task>assignedTask = new ArrayList<>();
    private final List<Task>createdTask = new ArrayList<>() ;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getCreatedTask() {
        return createdTask;
    }

    public List<Task> getAssignedTask() {
        return assignedTask;
    }

    public void addSubTask(Task task){
         assignedTask.add(task);
    }

    public void addCcreatedTask(Task task) {
        createdTask.add(task);
    }
}
