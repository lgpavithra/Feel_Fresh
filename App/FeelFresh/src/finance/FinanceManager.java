package finance;

import java.sql.ResultSet;
import model.dto.FinanceDTO;

public interface FinanceManager {

    public abstract String create(FinanceDTO dto);

    public abstract String update(String name,double value);

    public abstract ResultSet read();
    
    public abstract String delete(String name);
    
    public abstract Double getValue();

    public abstract void credit(String name,double value);

    public abstract void debit(String name,double value);
}
