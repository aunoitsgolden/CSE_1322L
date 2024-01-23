import java.util.Scanner;

class Coins {

    private int quantityOnHand;
    private float denomination;
    private float weight;

    public Coins(float denomination, float weight) {
        this.denomination = denomination;
        this.weight = weight;
    }

    public float getTotalWeight() {
        return denomination * weight;
    }

    public void increaseQuantity(int quantity) {
        quantityOnHand += quantity;
    }

    public void decreaseQuantity(int quantity) {
        if (quantityOnHand - quantity < 0) {
            quantityOnHand = 0;
        } else {
            quantityOnHand -= quantity;
        }

    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public String printPretty(float amount) {
        return("$"+ String.format("%4.2f", amount));
    }

    public String toString() {
        return printPretty(getTotalValue()) +" in "+ printPretty(denomination) +" coins.";
    }

}

class Notes {

    private int quantityOnHand;
    private int denomination;

    public Notes(int denomination) {
        this.denomination = denomination;
    }

    public int getTotalValue() {
        return denomination * quantityOnHand;
    }

    public void increaseQuantity(int quantity) {
        quantityOnHand += quantity;
    }

    public void decreaseQuantity(int quantity) {
        if (quantityOnHand - quantity < 0) {
            quantityOnHand = 0;
        } else {
            quantityOnHand -= quantity;
        }
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public String printPretty(float amount) {
        return("$"+ String.format("%4.2f", amount));
    }

    public String toString() {
        return printPretty(getTotalValue()) +" in "+ printPretty(denomination) +" notes.";
    }

}

public class Assignment1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Notes twenties = new Notes(20);
        Notes tens = new Notes(10);
        Notes fives = new Notes(5);
        Notes ones = new Notes(1);

        Coins quarters = new Coins(0.25f, 0.2f);
        Coins dimes = new Coins(0.10f, 0.08f);
        Coins nickels = new Coins(0.05f, 0.176f);
        Coins pennies = new Coins(0.01f, 0.088f);

        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);

        System.out.print(twenties);

    }
}
