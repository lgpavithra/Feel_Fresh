package finance;

import model.MYSQL;
import model.dto.TransactionDTO;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionManager {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TransactionManager.class);    
    
    public void create(TransactionDTO dTO) {
        String q = "INSERT INTO transactions (source, beneficiary, amount, debit_credit_flag, type, remark) "
                + "VALUES ('" + dTO.getSource() + "', '" + dTO.getBeneficiary() + "', " + dTO.getAmount() + ", '" + dTO.getFlag() + "', '" + dTO.getType() + "', '" + dTO.getRemark() + "')";
        try {
            MYSQL.executeIUD(q);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
    }

    public ResultSet read() {
        String q = "SELECT * FROM `transactions` ORDER BY created_at DESC";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            return rs;
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    public ResultSet read(String flag) {
        String q = "SELECT * FROM transactions "
                + "WHERE debit_credit_flag = '" + flag + "' "
                + "ORDER BY created_at DESC";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            return rs;
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    public ResultSet getByType() {
        String q = "SELECT type, COUNT(*) AS transaction_count, SUM(amount) AS total_amount "
                + "FROM transactions "
                + "GROUP BY type;";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            return rs;
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    public ResultSet getByType(String flag) {
        String q = "SELECT type, COUNT(*) AS transaction_count, SUM(amount) AS total_amount "
                + "FROM transactions "
                + "WHERE debit_credit_flag = '" + flag + "' AND type <> 'Damaged' "
                + "GROUP BY type";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            return rs;

        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    public String delete(int id) {
        String q = "DELETE FROM transactions WHERE id = " + id;
        try {
            MYSQL.executeIUD(q);
            return "Deleted Successfully";
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    public String getFlagValue(String flag) {
        String q = "SELECT SUM(amount) AS total_value_today "
                + "FROM transactions "
                + "WHERE debit_credit_flag = '" + flag + "' "
                + "  AND DATE(created_at) = CURDATE()";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            if (rs.next()) {
                return String.valueOf(rs.getString("total_value_today"));
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }
}
