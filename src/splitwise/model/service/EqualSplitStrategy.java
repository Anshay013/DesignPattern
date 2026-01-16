package splitwise.model.service;

import splitwise.model.Expense;
import splitwise.model.User;

import java.util.HashMap;
import java.util.List;

public class EqualSplitStrategy implements MoneySplitService{


    // this is the main logic
    @Override
    public void moneyAssignment(Expense expense, Double totalAmount) {
        List<User> participants = expense.getUserList();
        User leader = expense.getLeader();

        if (participants == null || participants.isEmpty()) return;

        double splitAmount = totalAmount / participants.size();

        for (User user : participants) {
            // The leader doesn't owe themselves
            if (user.getUserId().equals(leader.getUserId())) {
                continue;
            }

            // 1. Update Leader's Lending Status
            updateLending(leader, user, splitAmount);

            // 2. Update User's Owning Status
            updateOwing(user, leader, splitAmount);
        }
    }

    private void updateLending(User leader, User debtor, Double amount) {
        // Update global total
        leader.setTotLends(leader.getTotLends() + amount);

        // Update specific relationship: Leader -> Debtor
        HashMap<User, Double> lendsMap = leader.getLends();
        lendsMap.put(debtor, lendsMap.getOrDefault(debtor, 0.0) + amount);
    }

    private void updateOwing(User debtor, User leader, Double amount) {
        // Update global total
        debtor.setTotOwes(debtor.getTotOwes() + amount);

        // Update specific relationship: Debtor -> Leader
        HashMap<User, Double> owesMap = debtor.getOwes();
        owesMap.put(leader, owesMap.getOrDefault(leader, 0.0) + amount);
    }

}
