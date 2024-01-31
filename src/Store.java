import java.util.ArrayList;
public class Store {
    private ArrayList<Product> products;

    Store() {
        products = new ArrayList<Product>();
    }


    public boolean add(Product product) {
        return this.products.add(product);
    }
    public String listProducts() {
        String prodList = "";
        if (this.products.isEmpty()) {
            prodList = "No products have Been added";
        }
        else {
            for (int i = 0; i < this.products.size(); i++) {
                prodList += this.products.get(i).toString() + "\n";
            }
        }
        return prodList;
    }

    public double averageProductPrice(){
        double sum = 0;
        for (int i = 0; i < this.products.size();i++){
            sum += this.products.get(i).getUnitCost();
        }
        double average;
        if (this.products.size() > 0) {
             average = sum / this.products.size();
        }
        else {
            average = -1;
        }
        return average;
    }

    public String listCurrentProducts() {
        String prodList = "";

        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getIsCurrentProductLine()) {
                prodList += this.products.get(i).toString() + "\n";
            }
        }

        if (prodList.isEmpty()) {
            prodList = "Their are no Current Products";
        }
        return prodList;
    }
    public Product cheapestProduct(){
        Product cheapest = null;
        if (this.products.size()>0) {
            int cheapestIndex = 0;
            double cheapestCost = this.products.get(0).getUnitCost();
            for (int i = 0; i < this.products.size(); i++) {
                if (this.products.get(i).getUnitCost() < cheapestCost) {
                    cheapestCost = this.products.get(i).getUnitCost();
                    cheapestIndex = i;
                }
            }
            cheapest = this.products.get(cheapestIndex);
        }

        return cheapest;
    }
    public String listProductsAbovePrice(double price) {
        String prodList = "";

        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getUnitCost()>price) {
                prodList += this.products.get(i).toString() + "\n";
            }
        }

        if (prodList.isEmpty()) {
            prodList = "Their is no Products that cost more than " + price;
        }
        return prodList;
    }
}
