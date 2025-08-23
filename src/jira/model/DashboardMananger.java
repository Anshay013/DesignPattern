package jira.model;

import jira.manager.UniqueIdGenerator;

public abstract class DashboardMananger {


    public DashboardMananger(UniqueIdGenerator idGenerator){
        System.out.println("Init DashboardManager");
    }

    public abstract User createUser(String userName);
    public abstract Task createTask(User taskOwner, Task task);
    public abstract boolean assignTask(Task task, User assignUser);

}
