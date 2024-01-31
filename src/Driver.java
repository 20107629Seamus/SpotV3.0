import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Driver driver = new Driver();
        //driver.processOrder();
        //driver.runMenu();

    }
    Scanner input = new Scanner(System.in);
    Store store;

    private Driver() {
        store = new Store();
        this.runMenu();
    }

    private int mainMenu(){
        System.out.print("""
               Shop Menu
               ---------
                  1) Add another product
                  2) List the Products
                  ============================================================
                  3) List the current products
                  4) Display average product unit cost
                  5) Display cheapest product
                  6) List products that are more expensive than a given price
                  ============================================================
                  0) Exit
               ==>> """);
        int option = input.nextInt();
        return option;
    }
    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addProduct();
                case 2 -> printProducts();
                case 3 -> printCurrentProducts();
                case 4 -> printAverageProductPrice();
                case 5 -> printCheapestProduct();
                case 6 -> printProductsAboveAPrice();

                default -> System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine();

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye");
        System.exit(0);
    }
    private void addProduct() {
        System.out.print("Enter the Product Name:  ");
        String productName = input.nextLine();
        productName = input.nextLine();
        System.out.print("Enter the Product Code:  ");
        int productCode = input.nextInt();
        System.out.print("Enter the Unit Cost:  ");
        double unitCost = input.nextDouble();

        System.out.print("Is this product in your current line (y/n): ");
        char currentProduct = input.next().charAt(0);
        boolean inCurrentProductLine = false;
        if ((currentProduct == 'y') || (currentProduct == 'Y'))
            inCurrentProductLine = true;

        boolean isAdded = store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded) {
            System.out.println("Products added successfully");
        }
        else {
            System.out.println("No Product Added");
        }
        System.out.println("\n");

    }
    private void printProducts() {
        System.out.println("Product List:");
        System.out.println(store.listProducts());

    }

    private void printCurrentProducts(){
        System.out.println("List of Products in Current Line");
        System.out.println(store.listCurrentProducts());
    }
    private void printAverageProductPrice(){
        double averagePrice = store.averageProductPrice();

        if (averagePrice == -1) {
            System.out.println("Their is no products in store");
        }
        else{
            System.out.print("Average price is ");
            System.out.println(averagePrice);
        }
        System.out.println("");

    }

    private void printProductsAboveAPrice(){
        System.out.print("List Products Over this Price: ");
        double inputPrice = input.nextDouble();
        System.out.println(store.listProductsAbovePrice(inputPrice));


    }
    private void printCheapestProduct() {
        System.out.println("The cheapest item in the store is : ");
        if(store.cheapestProduct() != null) {
            System.out.println(store.cheapestProduct());
        }
        else{
            System.out.println("Their is no items in the store!");
        }

    }


}
