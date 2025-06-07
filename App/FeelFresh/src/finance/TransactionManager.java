package finance;

import model.MYSQL;
import model.dto.TransactionDTO;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public String delete(int id) {
        String q = "DELETE FROM transactions WHERE id = " + id;
        try {
            MYSQL.executeIUD(q);
            return "Deleted Successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }    
}
