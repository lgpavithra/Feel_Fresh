package inventory_process.inventory;

import finance.FinanceDepartment;
import gui.Flag;
import gui.Type;
import model.dto.GrnDTO;
import model.dto.InvoiceDTO;
import java.util.ArrayList;
import model.dto.ProductDTO;
import model.dto.RecieptDTO;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MYSQL;
import model.dto.DTOGenerator;
import model.dto.TransactionDTO;

public class InventoryManager {

    private static InventoryManager inventoryManager;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InventoryManager.class);

    public static InventoryManager getInstance() {
        if (inventoryManager == null) {
            inventoryManager = new InventoryManager();
        }
        return inventoryManager;
    }

    private InventoryManager() {
    }

    /* operations */
//    public RecieptDTO issueProducts(InvoiceDTO dto) {
//        //insert into the invoice table
//        String invoice = "INSERT INTO invoice ("
//                + "    cus_mobile,"
//                + "    total,"
//                + "    discount,"
//                + "    paid"
//                + ") VALUES ("
//                + "    '" + dto.getMobile() + "',"
//                + "    '" + dto.getTotal() + "',"
//                + "    '" + dto.getDiscount() + "',"
//                + "    '" + dto.getPaid() + "'"
//                + ")";
//        try {
//            MYSQL.executeIUD(invoice);
//
//            ResultSet invoiceID = MYSQL.executeSearch("SELECT LAST_INSERT_ID()");
//            int lastInsertedId = -1;
//            if (invoiceID.next()) {
//                lastInsertedId = invoiceID.getInt(1);
//            }
//            invoiceID.close();  // Always close ResultSet when done
//
//            for (ProductDTO productDTO : dto.getProductList()) {
//                //insert into the invoice item table
//
//                String invoiceItem = "INSERT INTO invoice_item ("
//                        + "invoice_id, "
//                        + "product_id, "
//                        + "qty"
//                        + ") VALUES ("
//                        + "'" + lastInsertedId + "', "
//                        + "'" + productDTO.getPid() + "', "
//                        + "'" + productDTO.getQty() + "'"
//                        + ")";
//                MYSQL.executeIUD(invoiceItem);
//
//                //getting stock details
//                String stockQ = "SELECT "
//                        + "id, "
//                        + "product_id, "
//                        + "grn_id, "
//                        + "selling_price, "
//                        + "exp_date, "
//                        + "qty, "
//                        + "DATEDIFF(exp_date, CURDATE()) AS days_until_expiry "
//                        + "FROM stock "
//                        + "WHERE "
//                        + "product_id = '" + productDTO.getPid() + "' "
//                        + "AND qty > 0 "
//                        + "AND exp_date IS NOT NULL "
//                        + "AND exp_date >= CURDATE() "
//                        + "ORDER BY exp_date ASC";
//
//                ResultSet stockDetails = MYSQL.executeSearch(stockQ);
//
//                /*================== SYNCH with the inventory levels ====================*/
//                while (stockDetails.next()) {
//                    Double currentQTY = stockDetails.getDouble("qty");
//                    if (productDTO.getQty() > currentQTY) {
//                        String query = "UPDATE stock "
//                                + "SET qty = '" + 0 + "' "
//                                + "WHERE id = '" + stockDetails.getString("id") + "'";
//                        MYSQL.executeIUD(query);
//                    } else {
//                        currentQTY = currentQTY - productDTO.getQty();
//                        String query = "UPDATE stock "
//                                + "SET qty = '" + currentQTY + "' "
//                                + "WHERE id = '" + stockDetails.getString("id") + "'";
//                        MYSQL.executeIUD(query);
//                        break;
//                    }
//                }
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        RecieptDTO reciept = new RecieptDTO();
//        reciept.setProductList(dto.getProductList());
//        reciept.setMobile(dto.getMobile());
//        reciept.setTotal(dto.getTotal());
//        reciept.setDiscount(dto.getDiscount());
//        reciept.setPaid(dto.getPaid());
//        return reciept;
//    }
    public void addStocks(GrnDTO dto) {
        //grn records
        String grn = "INSERT INTO grn ("
                + "    `supplier_id`,"
                + "	 `po_id`,"
                + "    `employee_nic`,"
                + "    `total`,"
                + "    `discount`,"
                + "    `paid_amount`,"
                + "    `outstanding`"
                + ") VALUES ("
                + "    '" + dto.getSupplier_id() + "',"
                + "    '" + dto.getPo_id() + "',"
                + "    '200312568946',"
                + "    '" + dto.getTotal() + "',"
                + "    '" + dto.getDiscount() + "',"
                + "    '" + dto.getPaid() + "',"
                + "    '" + dto.getOutstanding() + "'"
                + ")";

        logger.trace("Creating a new GRN");

        try {
            MYSQL.executeIUD(grn);
            //=============== comment this if error occured =============
            TransactionDTO dTO = DTOGenerator.getInstance().generateTransactionDTO("Supplier", "Inventory", dto.getPaid(), Flag.debit.toString(), Type.AssetBuying.toString(), "Buying products for inventory");
            FinanceDepartment.getTransactionManager().create(dTO);
            FinanceDepartment.getAssetManager().debit("Money", dto.getPaid());
            FinanceDepartment.getAssetManager().credit("Inventory", dto.getPaid());
            //=============== comment this if error occured =============
            
            ResultSet rs = MYSQL.executeSearch("SELECT LAST_INSERT_ID()");
            int lastId = -1;

            if (rs.next()) {
                lastId = rs.getInt(1);
                for (ProductDTO productDTO : dto.getProductList()) {
                    String grnItem = "INSERT INTO grn_item ("
                            + "    grn_id,"
                            + "    product_id,"
                            + "    buying_price,"
                            + "    selling_price,"
                            + "    qty"
                            + ") VALUES ("
                            + "    '" + lastId + "',"
                            + "    '" + productDTO.getPid() + "',"
                            + "    '" + productDTO.getBuyingPrice() + "',"
                            + "    '" + productDTO.getSellingPrice() + "',"
                            + "    '" + productDTO.getQty() + "'"
                            + ")";
                    MYSQL.executeIUD(grnItem);

                    String stockUpdate = "INSERT INTO stock ("
                            + "    product_id,"
                            + "    grn_id,"
                            + "    selling_price,"
                            + "    exp_date,"
                            + "    qty"
                            + ") VALUES ("
                            + "    '" + productDTO.getPid() + "',"
                            + "    '" + lastId + "',"
                            + "    '" + productDTO.getSellingPrice() + "',"
                            + "    '" + productDTO.getExpDate() + "',"
                            + "    '" + productDTO.getQty() + "'"
                            + ")";
                    MYSQL.executeIUD(stockUpdate);
                }
            }

            //stock level update
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
    }

    public ArrayList<ProductDTO> loadProducts() {
        System.out.println("Loading products from the inventory...");
        Inventory.getInstance().getProductList().clear();
        try {
            ResultSet rs = MYSQL.executeSearch(
                    "SELECT "
                    + "p.name AS product_name, "
                    + "b.name AS brand_name, "
                    + "c.name AS category_name "
                    + "FROM product p "
                    + "JOIN brand b ON p.brand_id = b.id "
                    + "JOIN category c ON p.category_id = c.id;"
            );

            while (rs.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setPname(rs.getString("product_name"));
                productDTO.setCategoryName(rs.getString("category_name"));
                productDTO.setBrandName(rs.getString("brand_name"));
                Inventory.getInstance().getProductList().add(productDTO);
            }

        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return Inventory.getInstance().getProductList();
    }

    /*
    
        next updates
        =============
        1. CRUD - products
        2.
     */
    public void issueProducts(ProductDTO productDTO) {        
        try {
            //getting stock details
            String stockQ = "SELECT "
                    + "id, "
                    + "product_id, "
                    + "grn_id, "
                    + "selling_price, "
                    + "exp_date, "
                    + "qty, "
                    + "DATEDIFF(exp_date, CURDATE()) AS days_until_expiry "
                    + "FROM stock "
                    + "WHERE "
                    + "product_id = '" + productDTO.getPid() + "' "
                    + "AND qty > 0 "
                    + "AND exp_date IS NOT NULL "
                    + "AND exp_date >= CURDATE() "
                    + "ORDER BY exp_date ASC";

            ResultSet stockDetails = MYSQL.executeSearch(stockQ);

            while (stockDetails.next()) {
                Double currentQTY = stockDetails.getDouble("qty");
                if (productDTO.getQty() > currentQTY) {
                    String query = "UPDATE stock "
                            + "SET qty = '" + 0 + "' "
                            + "WHERE id = '" + stockDetails.getString("id") + "'";
                    MYSQL.executeIUD(query);
                    logger.trace("Updating stock levels for the invoice");
                } else {
                    currentQTY = currentQTY - productDTO.getQty();
                    String query = "UPDATE stock "
                            + "SET qty = '" + currentQTY + "' "
                            + "WHERE id = '" + stockDetails.getString("id") + "'";
                    MYSQL.executeIUD(query);
                    break;
                }
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
    }

    public ResultSet getProductDetails(String barcode) {
        String q = "SELECT "
                + "    p.*, "
                + "    b.name AS brand_name, "
                + "    c.name AS category_name "
                + "FROM product p "
                + "JOIN brand b ON p.brand_id = b.id "
                + "JOIN category c ON p.category_id = c.id "
                + "WHERE p.barcode = '" + barcode + "'";

        try {
            ResultSet rs = MYSQL.executeSearch(q);
            if (rs.next()) {
                return rs;
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

    public ResultSet loadStocks() {
        String q = "SELECT "
                + "p.*, "
                + "SUM(s.qty) AS total_stock "
                + "FROM "
                + "product p "
                + "INNER JOIN "
                + "stock s ON p.id = s.product_id "
                + "GROUP BY "
                + "p.id "
                + "HAVING "
                + "total_stock > 0";
        try {
            ResultSet rs = MYSQL.executeSearch(q);
            return rs;  // Return ResultSet directly without calling rs.next()
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        }
        return null;
    }

}
