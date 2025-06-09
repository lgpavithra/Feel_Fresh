package inventory_process.inventory;

import model.dto.InvoiceDTO;
import model.dto.ProductDTO;
import model.dto.RecieptDTO;
import java.sql.ResultSet;
import model.MYSQL;

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
        try {
            MYSQL.executeIUD(invoice);

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
