package inventory_process.inventory;

import inventory_process.dto.InvoiceDTO;
import inventory_process.dto.ProductDTO;
import inventory_process.dto.RecieptDTO;
import java.sql.ResultSet;
import model.MYSQL;

public class InvoiceProcessor {

    public void process(InvoiceDTO dto) {
        System.out.println("INVOICE PROCESSOR: creating an invoice...");
        //insert into the invoice table
        String invoice = "INSERT INTO invoice ("
                + "    cus_mobile,"
                + "    total,"
                + "    discount,"
                + "    paid"
                + ") VALUES ("
                + "    '" + dto.getMobile() + "',"
                + "    '" + dto.getTotal() + "',"
                + "    '" + dto.getDiscount() + "',"
                + "    '" + dto.getPaid() + "'"
                + ")";
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
            ex.printStackTrace();
        }

        RecieptDTO reciept = new RecieptDTO();
        reciept.setProductList(dto.getProductList());
        reciept.setMobile(dto.getMobile());
        reciept.setTotal(dto.getTotal());
        reciept.setDiscount(dto.getDiscount());
        reciept.setPaid(dto.getPaid());
        //return reciept;
    }

}
