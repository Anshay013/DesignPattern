package splitwise.model;

import java.util.HashMap;
import java.util.List;

public class User {

    private String userId;
    private List<Group>groupList;
    private List<Expense>expenseList;
    private Double totOwes;
    private Double totLends;
    private HashMap<User, Double>Lends; // user -> money
    private HashMap<User, Double>owes; // user -> money

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public Double getTotOwes() {
        return totOwes;
    }

    public void setTotOwes(Double totOwes) {
        this.totOwes = totOwes;
    }

    public Double getTotLends() {
        return totLends;
    }

    public void setTotLends(Double totLends) {
        this.totLends = totLends;
    }

    public HashMap<User, Double> getLends() {
        return Lends;
    }

    public void setLends(HashMap<User, Double> lends) {
        Lends = lends;
    }

    public HashMap<User, Double> getOwes() {
        return owes;
    }

    public void setOwes(HashMap<User, Double> owes) {
        this.owes = owes;
    }


}
