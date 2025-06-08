package finance;

import java.sql.ResultSet;
import model.MYSQL;
import model.dto.FinanceDTO;

public class EquityManager implements FinanceManager {

    @Override
    public String create(FinanceDTO dto) {
        try {
            String checkQuery = "SELECT COUNT(*) AS count FROM finance WHERE name = '" + dto.getName() + "' AND type = '" + dto.getType() + "'";
            ResultSet rs = MYSQL.executeSearch(checkQuery);
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    return "Equity with this name and type already exists.";
                }
            }

            String q = "INSERT INTO finance (name, type, value) "
                    + "VALUES ('" + dto.getName() + "', '" + dto.getType() + "', '" + dto.getValue() + "')";
            MYSQL.executeIUD(q);
            return "Successfully created";
        } catch (Exception ex) {
            return "Exception occurred: " + ex.getMessage();
        }
    }

    @Override
    public String update(String name, double value) {        
        String q = "UPDATE finance "
                + "SET value = '" + value + "' "
                + "WHERE type = 'Liability' AND name = '" + name + "'";

        try {
            MYSQL.executeIUD(q);
            return "successfully updated";
        } catch (Exception ex) {
            return "Exception occured: " + ex.getMessage();
        }
    }

    @Override
    public ResultSet read() {
        String q = "SELECT * FROM finance WHERE type = 'Equity'";
        try {
            return MYSQL.executeSearch(q);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String delete(String name) {
        String q = "DELETE FROM finance "
                + "WHERE name = '" + name + "' AND type = 'Equity'";
        try {
            MYSQL.executeIUD(q);
            return "successfully deleted";
        } catch (Exception ex) {
            return "Exception occured: " + ex.getMessage();
        }
    }

    @Override
    public Double getValue() {
        String q = "SELECT SUM(value) AS total_equity_value "
                + "FROM finance "
                + "WHERE type = 'Equity'";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            while (rs.next()) {
                return rs.getDouble("total_equity_value");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void credit(String name, double value) {
        String q = "UPDATE finance "
                + "SET value = value + '" + value + "'"
                + "WHERE type = 'Equity' AND name = '" + name + "'";
        try {
            MYSQL.executeIUD(q);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void debit(String name, double value) {
        String q = "UPDATE finance "
                + "SET value = value - '" + value + "'"
                + "WHERE type = 'Equity' AND name = '" + name + "'";
        try {
            MYSQL.executeIUD(q);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
