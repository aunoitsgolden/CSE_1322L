import java.util.Scanner;

class StockItem {

    private String description;
    private float price;
    private int quantity;
    private int id;
    private static int totalItems;

    public StockItem() {
        this("empty", 0.00f, 0);
    }

    public StockItem(String description, float price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        id = totalItems++;
    }

    public String toString() {
        return getId()+" of "+(totalItems - 1)+": "+getQuantity()+" "+getDescription()+" has price $"+getPrice();
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(float price) {
        if (this.price + price <= 0) {
            throw new IllegalArgumentException("Lowering the value by "+price+" results in the price going below 0.");
        } else {
            this.price = price;
        }
    }

    public void raiseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void lowerQuantity(int quantity) {
        if (this.quantity - quantity < 0) {
            throw new IllegalArgumentException("Lowering the quantity by "+quantity+" results in the quantity going below 0.");
        } else {
            this.quantity -= quantity;
        }
    }
}

public class Lab2 {
    public static void main(String args[]) {
        StockItem milk = new StockItem("gallon of milk", 3.60f, 15);
        StockItem bread = new StockItem("loaf of bread", 1.98f, 30);
        Scanner input = new Scanner(System.in);
        int menuInput;

        do {
            float newPrice = 0;
            int quantityAdjustment = 0;

            System.out.println("\n1. Sold One Milk"
                            +"\n2. Sold One Bread"
                            +"\n3. Change price of Milk"
                            +"\n4. Change price of Bread"
                            +"\n5. Add Milk to Inventory"
                            +"\n6. Add Bread to Inventory"
                            +"\n7. See Inventory"
                            +"\n8. Quit"
            );
            menuInput = input.nextInt();

            switch (menuInput) {
                case 1:
                    milk.lowerQuantity(1);
                    break;

                case 2:
                    bread.lowerQuantity(1);
                    break;

                case 3:
                    System.out.print("What is the new price for milk? ");
                    newPrice = input.nextFloat();
                    milk.setPrice(newPrice);
                    break;

                case 4: 
                    System.out.print("What is the new price for bread? ");
                    newPrice = input.nextFloat();
                    bread.setPrice(newPrice);
                    break;

                case 5:
                    System.out.print("How much milk did we get? ");
                    quantityAdjustment = input.nextInt();
                    milk.raiseQuantity(quantityAdjustment);
                    break;

                case 6:
                    System.out.print("How much bread did we get? ");
                    quantityAdjustment = input.nextInt();
                    bread.raiseQuantity(quantityAdjustment);
                    break;

                case 7:
                    System.out.println(milk);
                    System.out.println(bread); 
            }

        } while (menuInput != 8);
        input.close();

    }

}
