
public class Product {
    private String productName;
    private int productCode;
    private double unitCost;
    private boolean isCurrentProductLine;
    Product(){

    };

    Product(String productName, int productCode, double unitCost,boolean isCurrentProductLine) {
        this.productName = productName;
        this.productCode = productCode;
        this.unitCost = unitCost;
        this.isCurrentProductLine = isCurrentProductLine;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setProductCode(int productCode){
        this.productCode = productCode;
    }
    public void setUnitCost(double unitCost){
        this.unitCost = unitCost;
    }

    public void setIsCurrentProductLine(boolean isCurrentProductLine){
        this.isCurrentProductLine = isCurrentProductLine;
    }
    public String getProductName(){
        return this.productName;
    }
    public int getProductCode(){
        return this.productCode;
    }
    public double getUnitCost(){
        return this.unitCost;
    }

    public boolean getIsCurrentProductLine(){
        return this.isCurrentProductLine;
    }

    public String toString() {
        String result = (
                "Name: " + this.productName
                + " Code: " + this.productCode
                + " Cost: " + this.unitCost
                );
        if (this.isCurrentProductLine){
            result += " This is in Product Line";
        }
        else{
            result += " This is out of Product Line ";
        }
        return result;
    }
}
