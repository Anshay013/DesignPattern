package jira.manager;

import jira.model.User;

public class UserSearchEngineImpl implements UserSearchEngine {

    private User userResult;

    @Override
    public void pushedFromResults(User userResult) {
        this.userResult = userResult;
    }

    @Override
    public User getUserResult() {
        return userResult;
    }

}
