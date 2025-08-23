package jira.manager;

import jira.model.DashboardMananger;
import jira.model.ModelType;
import jira.model.Task;
import jira.model.User;

public class DashBoardManagerImpl extends DashboardMananger {

    private UniqueIdGenerator idGenerator;

    public DashBoardManagerImpl(UniqueIdGenerator idGenerator) {
        super(idGenerator);
        this.idGenerator = idGenerator;
    }

    @Override
    public User createUser(String userName) {
        User user =  new User();
        user.setName(userName); // basically Email Id.

        user.setUserId(idGenerator.generateUniqueID(ModelType.USER, userName));

        // save this user to DB
        return user;
    }

    @Override
    public Task createTask(User taskOwner, Task task) {
        // here instead of creating a task. get all task details from UI.
        task.setTaskId(idGenerator.generateUniqueID(ModelType.TASK, taskOwner.getName()));

       // searchFun.pushedFromResults(new User()); // any existing user query DB and get user. Pass this from UI

        // save this task to DB

        return task;
    }

    @Override
    public boolean assignTask(Task task, User assignUser) {
        try {
            assignUser.addSubTask(task);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
