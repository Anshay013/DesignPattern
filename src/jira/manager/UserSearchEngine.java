package jira.manager;

import jira.model.User;

public interface UserSearchEngine {

    public void pushedFromResults(User userResult);
    public User getUserResult();
}
