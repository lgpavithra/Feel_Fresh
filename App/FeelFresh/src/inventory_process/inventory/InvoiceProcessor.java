package inventory_process.inventory;

import finance.FinanceDepartment;
import gui.Flag;
import gui.Type;
import model.dto.InvoiceDTO;
import model.dto.ProductDTO;
import model.dto.RecieptDTO;
import java.sql.ResultSet;
import model.MYSQL;
import model.dto.DTOGenerator;
import model.dto.TransactionDTO;

public class InvoiceProcessor {
    
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InvoiceProcessor.class);

    public void process(InvoiceDTO dto) {        
        //insert into the invoice table
        String invoice = "INSERT INTO invoice ("
                + "    cus_nic,"
                + "    total,"
                + "    discount,"
                + "    paid"
                + ") VALUES ("
                + "    '" + dto.getNic() + "',"
                + "    '" + dto.getTotal() + "',"
                + "    '" + dto.getDiscount() + "',"
                + "    '" + dto.getPaid() + "'"
                + ")";

        logger.trace("Creating a new Invoice");


        TransactionDTO dTO = DTOGenerator.getInstance().generateTransactionDTO("Customer", "Finance", dto.getTotal(), Flag.credit.toString(), Type.Income.toString(), "Recieving cash from a invoice");
        FinanceDepartment.getTransactionManager().create(dTO);
        double totalBuyingPrice = 0;
        for (ProductDTO productDTO : dto.getProductList()) {
            double buyingPrice = productDTO.getBuyingPrice(); // returns double
            int qty = productDTO.getQty();
            totalBuyingPrice = totalBuyingPrice + buyingPrice * qty;
        }

        double profit = dto.getPaid()- totalBuyingPrice;


        try {
            MYSQL.executeIUD(invoice);
            
            //=============== comment this if error occured =============
            FinanceDepartment.getAssetManager().credit("Money", dto.getPaid());
            FinanceDepartment.getAssetManager().debit("Inventory", totalBuyingPrice);
            FinanceDepartment.getEquityManager().credit("Profit", profit);
            FinanceDepartment.getTransactionManager().create(dTO);
            //=============== comment this if error occured =============
            
            ResultSet invoiceID = MYSQL.executeSearch("SELECT LAST_INSERT_ID()");
            int lastInsertedId = -1;
            if (invoiceID.next()) {
                lastInsertedId = invoiceID.getInt(1);
            }
            invoiceID.close();  // Always close ResultSet when done

            for (ProductDTO productDTO : dto.getProductList()) {
                //insert into the invoice item table

                String invoiceItem = "INSERT INTO invoice_item ("
                        + "invoice_id, "
                        + "product_id, "
                        + "qty"
                        + ") VALUES ("
                        + "'" + lastInsertedId + "', "
                        + "'" + productDTO.getPid() + "', "
                        + "'" + productDTO.getQty() + "'"
                        + ")";
                MYSQL.executeIUD(invoiceItem);
                InventoryManager.getInstance().issueProducts(productDTO);
            }

        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }

        RecieptDTO reciept = new RecieptDTO();
        reciept.setProductList(dto.getProductList());
        reciept.setNic(dto.getNic());
        reciept.setTotal(dto.getTotal());
        reciept.setDiscount(dto.getDiscount());
        reciept.setPaid(dto.getPaid());
        //return reciept;
    }

}
