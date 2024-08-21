import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    class Transaction {
        String name, city;
        int amount, time;

        Transaction(String input) {
            String[] split = input.split(",");
            this.name = split[0];
            this.time = Integer.parseInt(split[1]);
            this.amount = Integer.parseInt(split[2]);
            this.city = split[3]; 
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>(); 
        HashMap<String, List<Transaction>> map = new HashMap<>();

        for (String t : transactions) {
            Transaction tran = new Transaction(t);
            map.putIfAbsent(tran.name, new ArrayList<>());
            map.get(tran.name).add(tran);
        }

        for (String t : transactions) {
            Transaction tran = new Transaction(t);
            if (!isValid(tran, map.get(tran.name))) {
                ans.add(t);  
            }
        }

        return ans;
    }

    public boolean isValid(Transaction t, List<Transaction> list) {
        if (t.amount > 1000) {
            return false;
        }

        for (Transaction l : list) {
            if (!t.city.equals(l.city) && Math.abs(t.time - l.time) <= 60) {
                return false;
            }
        }
        return true;
    }
}
