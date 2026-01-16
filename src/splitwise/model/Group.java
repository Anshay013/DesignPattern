package splitwise.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private String groupId;
    private List<User> userList;
    private List<Expense>expenseList;

    public void init(String prefix) {
        groupId = prefix + UUID.randomUUID().toString();
        userList = new ArrayList<>();
        expenseList = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }


}
