package jira.model;

import jira.manager.TaskDescription;

public class TaskDescriptionImpl implements TaskDescription {

    private TaskJson json;

    @Override
    public void setResultFromUI(TaskJson json) {
        this.json = json;
    }



}
