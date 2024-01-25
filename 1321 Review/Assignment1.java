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

    public float getTotalValue() {   
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

    public int getDenomination() {
        return denomination;
    }

    public String printPretty(float amount) {
        return("$"+ String.format("%4.2f", amount));
    }

    public String toString() {
        return printPretty(getTotalValue()) +" in "+ printPretty(denomination) +" notes.";
    }


}

public class Assignment1 {
    public static float compositeTotal(Notes[] notes, Coins[] coins) {
        float composite = 0;

        for (Notes x: notes) {
            composite += x.getTotalValue();
        }
        for (Coins x: coins) {
            composite += x.getTotalValue();
        }

        return composite;
    }

    public static float compositeWeight(Coins[] coins) {
        float composite = 0;

        for (Coins x: coins) {
            composite += x.getTotalWeight();
        }

        return composite;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Notes twenties = new Notes(20);
        Notes tens = new Notes(10);
        Notes fives = new Notes(5);
        Notes ones = new Notes(1);
        Notes[] allNotes = {twenties, tens, fives, ones};

        Coins quarters = new Coins(0.25f, 0.2f);
        Coins dimes = new Coins(0.10f, 0.08f);
        Coins nickels = new Coins(0.05f, 0.176f);
        Coins pennies = new Coins(0.01f, 0.088f);
        Coins[] allCoins = {quarters, dimes, nickels, pennies};

        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);

        for (Notes x: allNotes) {
            System.out.println(x);
        }
        for (Coins x: allCoins) {
            System.out.println(x);
        }

        System.out.println("Total money is "+ "$"+ String.format("%4.2f", compositeTotal(allNotes, allCoins)) + " total weight is "+ compositeWeight(allCoins) +"oz.");

        System.out.print("How much do you need? ");
        float amountNeeded = input.nextFloat();

        while (amountNeeded != 0) {
            float amountAdjustment = 0;

            for (Notes x : allNotes) { // make sure this isn't hardcoded so that amountNeeded > 1, this continues running
                if (amountNeeded > x.getDenomination() && x.getTotalValue() > 0) {
                    amountAdjustment = x.getDenomination();

                    System.out.println("Give them a "+String.format("%4.2f", amountAdjustment)+" note");
                    amountNeeded -= amountAdjustment;
                    x.decreaseQuantity(1); // (y == quantityGiven) could be more efficient? (x.getTotalValue() > 0 in iff&&) (keep in mind we need to print every note given) 
                } 
            }
            for (Coins x : allCoins) {
                if (amountNeeded > x.getDenomination() && x.getTotalValue() > 0) {
                    amountAdjustment = x.getDenomination();

                    System.out.println("Give them a "+String.format("%4.2f", amountAdjustment)+" "); // need to add +quarters, ... ,  pennies); 
                    amountNeeded -= amountAdjustment;
                    x.decreaseQuantity(1); 
                } 
            }
        }
        System.out.println("Total money is "+ "$"+ String.format("%4.2f", compositeTotal(allNotes, allCoins)) + " total weight is "+ compositeWeight(allCoins) +"oz.");
        input.close();
    }
}
