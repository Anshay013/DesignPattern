package splitwise;

import kotlin.Pair;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.model.User;
import splitwise.model.service.MoneySplitService;

import java.util.List;

public abstract class SplitWiseService {

    public SplitWiseService( MoneySplitService moneySplitStrategy){

    }

     abstract Group CreateGroup(List<User> userList, String prefix);

    public void addUser(User user, Group group){
        System.out.println("SplitWiseService add user");
    }

    abstract Expense addExpense(Group group, User user, List<User>userList, Double money); // calls money shuffle algo




    // A button toggle
    public abstract List<List<String>> simplifyGroupDebts(Group group);



}
