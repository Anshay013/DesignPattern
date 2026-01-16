package splitwise.model.service;

import splitwise.model.Expense;

public interface MoneySplitService {

    void moneyAssignment(Expense expense, Double money);
}
