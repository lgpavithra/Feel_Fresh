package model.dto;

import model.dto.GrnDTO;
import model.dto.InvoiceDTO;
import model.dto.ProductDTO;
import java.util.ArrayList;
import java.util.Arrays;

public class DTOGenerator {

    private DTOGenerator() {
    }

    private static DTOGenerator dTOGenerator;

    public static DTOGenerator getInstance() {
        if (dTOGenerator == null) {
            dTOGenerator = new DTOGenerator();
        }
        return dTOGenerator;
    }

    public GrnDTO generateGrnDTO(ArrayList<ProductDTO> productList, int po_id, double total, double discount, double paid, double outstanding, int supplier_id) {
        if (total == 0) {
            System.out.println("Please enter a valid amount for total");
            return null;
        } else if (productList.isEmpty()) {
            System.out.println("add Products");
            return null;
        } else if (paid == 0) {
            System.out.println("Please enter a valid paid amount");
            return null;
        } else {
            GrnDTO dTO = new GrnDTO();
            dTO.setProductList(productList);
            dTO.setPo_id(po_id);
            dTO.setTotal(total);
            dTO.setDiscount(discount);
            dTO.setPaid(paid);
            dTO.setOutstanding(outstanding);
            dTO.setSupplier_id(supplier_id);
            return dTO;
        }
    }

    public InvoiceDTO generateInvoiceDTO(ArrayList<ProductDTO> productList, double total, double paid, double discount, String mobile) {
        //productList,total,paid,discount,mobile
        if (productList.isEmpty()) {
            System.out.println("Please add products");
            return null;
        } else if (total == 0) {
            System.out.println("Please enter a valid total amount");
            return null;
        } else if (paid == 0) {
            System.out.println("Please enter a valid amount to the paid value");
            return null;
        } else if (mobile.isBlank()) {
            System.out.println("Please enter a mobile number");
            return null;
        } else {
            InvoiceDTO dTO = new InvoiceDTO();
            dTO.setMobile(mobile);
            dTO.setTotal(total);
            dTO.setDiscount(discount);
            dTO.setPaid(paid);
            dTO.setProductList(productList);
            return dTO;
        }
    }

    public FinanceDTO generateFinanceDTO(String name, String type, double value) {

        String[] allowedTypes = {"Asset", "Liability", "Equity"};

        if (name == null) {
            System.out.println("Name cannot be a null value");
            return null;
        } else if (!Arrays.asList(allowedTypes).contains(type)) {
            System.out.println("Invalid type");
            return null;
        } else {
            FinanceDTO dto = new FinanceDTO();
            dto.setName(name);
            dto.setType(type);
            dto.setValue(value);
            return dto;
        }
    }

    public TransactionDTO generateTransactionDTO(String source, String beneficiary, double amount, String flag, String type, String remark) {
        if (source.isEmpty()) {
            System.out.println("source cannot be null");
            return null;
        } else if (beneficiary.isEmpty()) {
            System.out.println("beneficiary cannot be null");
            return null;
        } else if (amount == 0) {
            System.out.println("amount cannot be null");
            return null;
        } else if (flag.isEmpty()) {
            System.out.println("flag cannot be null");
            return null;
        } else if (type.isEmpty()) {
            System.out.println("type cannot be null");
            return null;
        } else if (remark.isEmpty()) {
            System.out.println("remark cannot be null");
            return null;
        } else {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setSource(source);
            transactionDTO.setBeneficiary(beneficiary);
            transactionDTO.setAmount(amount);
            transactionDTO.setFlag(flag);
            transactionDTO.setType(type);
            transactionDTO.setRemark(remark);
            return transactionDTO;
        }
    }

    public ProductDTO generateProductDTO(String pid, double buyingPrice, double sellingPrice, int qty, String expDate) {
        if (pid.isEmpty()) {
            System.out.println("pid cannot be empty");
            return null;
        } else if (buyingPrice < 0) {
            System.out.println("buying price should be greater than 0");
            return null;
        } else if (sellingPrice < 0) {
            System.out.println("selling price should be greater than 0");
            return null;
        } else if (buyingPrice > sellingPrice) {
            System.out.println("Buying price should be less than selling price");
            return null;
        } else if (qty < 0) {
            System.out.println("quantity should be greater than 0");
            return null;
        }else if(expDate.isEmpty()){
            System.out.println("expire date should not be null");
            return null;
        }else{
            ProductDTO dTO = new ProductDTO();
            dTO.setPid(Integer.valueOf(pid));
            dTO.setBuyingPrice(buyingPrice);
            dTO.setSellingPrice(sellingPrice);
            dTO.setQty(qty);
            dTO.setExpDate(expDate);
            return dTO;
        }
    }
}
