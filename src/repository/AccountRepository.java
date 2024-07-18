package repository;

import model.Account;
import model.Transaction;

import java.util.List;
import java.util.Map;

public class AccountRepository {
    //user, Accounts
    Map<Integer, List<Account>> accounts;
    //account, transactions
    Map<Integer, List<Transaction>> accountsTransactions;
}
