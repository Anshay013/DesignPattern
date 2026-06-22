package splitwise;

import kotlin.Pair;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.model.User;
import splitwise.model.service.MoneySplitService;

import java.util.*;

public class GroupManager extends SplitWiseService{

    private final MoneySplitService moneySplitService;

    public GroupManager(MoneySplitService moneySplitStrategy) {
        super(moneySplitStrategy);
        this.moneySplitService = moneySplitStrategy;
    }


    @Override
    public Group CreateGroup(List<User> userList, String prefix){
        Group group = new Group();
        group.init(prefix);
         userList.forEach(
                 x -> {
                     group.getUserList().add(x);
                 }
         );
         return group;
    }



    @Override
    public Expense addExpense(Group group, User user, List<User>userList, Double money) {
        Expense expense = new Expense();
        expense.setGroupId(group.getGroupId());
        expense.setLeader(user);
        expense.setUserList(userList);

        moneySplitService.moneyAssignment(expense, money);

        // reconcile balances between leader and other participants.
        User leader = expense.getLeader();
        for (User participant : expense.getUserList()) {
            if (!participant.getUserId().equals(leader.getUserId())) {
                // We only care about the relationship between the payer and the debtors
                reconcileBalances(leader, participant);
            }
        }

       return expense;

    }


    private void    reconcileBalances(User userA, User userB) {
        // 1. Fetch current unidirectional debts
        double aOwesB = userA.getOwes().getOrDefault(userB, 0.0);
        double bOwesA = userB.getOwes().getOrDefault(userA, 0.0);

        // 2. Determine net debt and update relationship maps
        if (aOwesB > bOwesA) {
            double netDebt = aOwesB - bOwesA;

            // User A still owes User B the difference
            userA.getOwes().put(userB, netDebt);
            userB.getLends().put(userA, netDebt);

            // Remove the inverse mapping
            userB.getOwes().remove(userA);
            userA.getLends().remove(userB);
        }
        else if (bOwesA > aOwesB) {
            double netDebt = bOwesA - aOwesB;

            // User B still owes User A the difference
            userB.getOwes().put(userA, netDebt);
            userA.getLends().put(userB, netDebt);

            // Remove the inverse mapping
            userA.getOwes().remove(userB);
            userB.getLends().remove(userA);
        }
        else {
            // They owe each other the same amount; clear both
            userA.getOwes().remove(userB);
            userB.getLends().remove(userA);
            userB.getOwes().remove(userA);
            userA.getLends().remove(userB);
        }

        // 3. Recalculate global totals for both users (optional but recommended)
        recalculateTotalBalances(userA);
        recalculateTotalBalances(userB);
    }

    private void recalculateTotalBalances(User user) {
        user.setTotOwes(user.getOwes().values().stream().mapToDouble(Double::doubleValue).sum());
        user.setTotLends(user.getLends().values().stream().mapToDouble(Double::doubleValue).sum());
    }
    @Override
    public List<List<String>> simplifyGroupDebts(Group group) {
        System.out.println("SplitWiseService simplifyGroupDebts");

        List<List<String>> expenseChart = new ArrayList<>();

        List<User>candidates = group.getUserList();

        // form Heaps.

        TreeMap<Double, List<String>>ownsHeap = new TreeMap<>();
        TreeMap<Double, List<String>>lendsHeap = new TreeMap<>();

        for (User user : candidates) {
//            HashMap<User, Double>lendsMap = user.getLends();
//            HashMap<User, Double>ownsMap = user.getOwes();
//
//            Double totLend = 0.00;
//            for(Map.Entry<User, Double> entry : lendsMap.entrySet()) totLend += entry.getValue();
//            Double totOwe = 0.00;
//            for(Double value : ownsMap.values()) totOwe += value;

          //  ownsMap.values().stream().mapToDouble(x -> x).sum();

            Double debt =  user.getTotOwes() - user.getTotLends();
           if(debt < 0) {
               lendsHeap.computeIfAbsent(debt, k -> new ArrayList<>()).add(user.getUserId());
           }
           else if(debt > 0) ownsHeap.computeIfAbsent(debt, k -> new ArrayList<>()).add(user.getUserId());
      }
        // heap is formed

        // heapify
        while(!ownsHeap.isEmpty() && !lendsHeap.isEmpty()) {
            Map.Entry<Double, List<String>> ownsEntry = ownsHeap.pollLastEntry();
            Map.Entry<Double, List<String>> lendsEntry = lendsHeap.pollFirstEntry();

             Double ownsValue = ownsEntry.getKey(); //  max
             Double lendsValue = lendsEntry.getKey();   // min

             List<String> ownsIds = ownsEntry.getValue();
             List<String> lendsIds = lendsEntry.getValue();

                 String ouid = ownsIds.getLast();
                 String luid = lendsIds.getLast();


                 lendsIds.removeLast();
                 ownsIds.removeLast();
                 Double val = ownsValue + lendsValue;


                  if(ownsValue  > lendsValue * -1.00) {
                     ownsHeap.computeIfAbsent(val, k -> new ArrayList<>()).add(ouid);
                 }

                 else if(ownsValue  < lendsValue * -1.00){
                     lendsHeap.computeIfAbsent(val, k -> new ArrayList<>()).add(luid);
                 }

            expenseChart.add(new ArrayList<>(Arrays.asList(luid, ouid, val.toString())));

            if(ownsIds.isEmpty()) ownsHeap.remove(ownsValue);
            if(lendsIds.isEmpty()) lendsHeap.remove(lendsValue);

             }

            return expenseChart;

        }

}
