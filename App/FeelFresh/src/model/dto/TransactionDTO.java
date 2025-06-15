package model.dto;

public class TransactionDTO {
    private String source;
    private String beneficiary;
    private double amount;
    private String flag;
    private String type;
    private String remark;
    
    public String getSource() {
        return source;
    }
   
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getBeneficiary() {
        return beneficiary;
    }
    
    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }
  
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getFlag() {
        return flag;
    }
    
    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
}

