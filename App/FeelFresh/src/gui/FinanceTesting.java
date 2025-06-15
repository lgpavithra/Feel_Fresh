package gui;

import finance.FinanceDepartment;
import model.dto.DTOGenerator;
import model.dto.FinanceDTO;
import model.dto.ProductDTO;
import model.dto.TransactionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinanceTesting {

    public static void main(String[] args) {
        //ASSETS
        /*FinanceDTO financedto = DTOGenerator.getInstance().generateFinanceDTO("Money", "Asset", 10);
        FinanceDTO financedto1 = DTOGenerator.getInstance().generateFinanceDTO("recievable", "Asset", 1000);        
        */
        
        //Liabilities
        //FinanceDTO financedto = DTOGenerator.getInstance().generateFinanceDTO("Bank-loan", "Liability", 10);
        
        //Equity
        //FinanceDTO financedto = DTOGenerator.getInstance().generateFinanceDTO("Investment", "Equity", 6000);
        
        //if (financedto != null) {
            /*System.out.println("Dto is generated");
            System.out.println(FinanceDepartment.getAssetManager().create(financedto1));
            System.out.println(FinanceDepartment.getAssetManager().create(financedto1));
            System.out.println(FinanceDepartment.getAssetManager().read());
            System.out.println(FinanceDepartment.getAssetManager().delete("Money"));
            System.out.println(FinanceDepartment.getAssetManager().getValue());
            FinanceDepartment.getAssetManager().credit("Money", 2000);
            FinanceDepartment.getAssetManager().debit("Money", 2000);
            System.out.println(FinanceDepartment.getAssetManager().update("Money", 2000));
            */            
            
            //System.out.println(FinanceDepartment.getLiabilityManager().create(financedto));
            //System.out.println(FinanceDepartment.getLiabilityManager().update("Bank-loan", 2000));
            //System.out.println(FinanceDepartment.getAssetManager().read());
            //FinanceDepartment.getLiabilityManager().credit("Bank-loan", 20000);
            //FinanceDepartment.getLiabilityManager().debit("Bank-loan", 20000);
            //System.out.println(FinanceDepartment.getLiabilityManager().getValue());
            //System.out.println(FinanceDepartment.getLiabilityManager().delete("Bank-loan"));
            
            //System.out.println(FinanceDepartment.getEquityManager().create(financedto));
            //System.out.println(FinanceDepartment.getEquityManager().update("Investment", 3000));
            //System.out.println(FinanceDepartment.getEquityManager().read());
            //FinanceDepartment.getEquityManager().credit("Investment", 20000);
            //FinanceDepartment.getEquityManager().debit("Investment", 20000);
            //System.out.println(FinanceDepartment.getEquityManager().getValue());
            //System.out.println(FinanceDepartment.getEquityManager().delete("Investment"));                                               
        //} else {
          //  System.out.println("null returned");
        //}
//        
        TransactionDTO dTO = DTOGenerator.getInstance().generateTransactionDTO("Supplier", "Inventory", 1000, Flag.debit.toString(), Type.Damaged.toString(), "Products are buying to inventory");
        if(dTO != null){
            System.out.println("Dto is created");
            System.out.println(dTO.getType());
            FinanceDepartment.getTransactionManager().create(dTO);
            ResultSet rs = FinanceDepartment.getTransactionManager().getByType("credit");
            ResultSet rs1 = FinanceDepartment.getTransactionManager().read("credit");
            try {
                while (rs1.next()) {
                    System.out.println(rs1.getString("remark"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("DTO is null");
        }                                 
    }
}
