package finance;

import model.MYSQL;
import model.dto.TransactionDTO;
import java.sql.ResultSet;

public class TransactionManager {

    public void create(TransactionDTO dTO) {
         String q = "INSERT INTO transactions (source, beneficiary, amount, debit_credit_flag, type, remark) "
                + "VALUES ('" + dTO.getSource() + "', '" + dTO.getBeneficiary() + "', " + dTO.getAmount() + ", '" + dTO.getFlag() + "', '" + dTO.getType() + "', '" + dTO.getRemark() + "')";
        try {
            MYSQL.executeIUD(q);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet read() {
        String q = "SELECT * FROM `transactions`";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            return rs;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
