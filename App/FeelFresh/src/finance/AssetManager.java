package finance;

import inventory_process.test;
import java.sql.ResultSet;
import model.MYSQL;
import model.dto.FinanceDTO;

public class AssetManager implements FinanceManager {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AssetManager.class);
    
    @Override
    public String create(FinanceDTO dto) {
        try {
            String checkQuery = "SELECT COUNT(*) AS count FROM finance WHERE name = '" + dto.getName() + "' AND type = '" + dto.getType() + "'";
            ResultSet rs = MYSQL.executeSearch(checkQuery);
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    return "Asset with this name and type already exists.";
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
                + "WHERE type = 'Asset' AND name = '" + name + "'";
        try {
            MYSQL.executeIUD(q);
            return "successfully updated";
        } catch (Exception ex) {
            return "Exception occured: " + ex.getMessage();
        }
    }

    @Override
    public ResultSet read() {
        String q = "SELECT * FROM finance WHERE type = 'Asset'";
        try {
            return MYSQL.executeSearch(q);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    @Override
    public void credit(String name, double value) {
        String q = "UPDATE finance "
                + "SET value = value + '" + value + "'"
                + "WHERE type = 'Asset' AND name = '" + name + "'";
        try {
            MYSQL.executeIUD(q);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
    }

    @Override
    public void debit(String name, double value) {
        String q = "UPDATE finance "
                + "SET value = value - '" + value + "'"
                + "WHERE type = 'Asset' AND name = '" + name + "'";
        try {
            MYSQL.executeIUD(q);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
    }

    @Override
    public Double getValue() {
        String q = "SELECT SUM(value) AS total_asset_value "
                + "FROM finance "
                + "WHERE type = 'Asset'";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            while (rs.next()) {
                return rs.getDouble("total_asset_value");
            }

        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    @Override
    public String delete(String name) {
        String q = "DELETE FROM finance "
                + "WHERE name = '" + name + "' AND type = 'Asset'";
        try {
            MYSQL.executeIUD(q);
            return "successfully deleted";
        } catch (Exception ex) {
            return "Exception occured: " + ex.getMessage();
        }
    }

}
