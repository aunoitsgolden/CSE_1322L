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
        return weight * quantityOnHand;
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
        float amountNeeded;
        boolean changeGiven = true;

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
        
        System.out.println("Total Money is $"+ String.format("%4.2f", compositeTotal(allNotes, allCoins))+ " total weight is "+ compositeWeight(allCoins) +"oz.");

        System.out.print("How much do you need? ");
        amountNeeded = input.nextFloat();

        do {
            float amountAdjustment = 0;
            String coinString = "";

            if (amountNeeded >= 20 && twenties.getTotalValue() >= 20) {
                amountAdjustment = 20;
                twenties.decreaseQuantity(1);
                
            } else if (amountNeeded >= 10 && tens.getTotalValue() >= 10) {
                amountAdjustment = 10;
                tens.decreaseQuantity(1);
            
            } else if (amountNeeded >= 5 && fives.getTotalValue() >= 5) {
                amountAdjustment = 5;
                fives.decreaseQuantity(1);

            } else if (amountNeeded >= 1 && ones.getTotalValue() >= 1) {
                amountAdjustment = 1;
                ones.decreaseQuantity(1);

            } else if (amountNeeded >= 0.25 && quarters.getQuantityOnHand() > 0) {
                amountAdjustment = 0.25f;
                quarters.decreaseQuantity(1);
                coinString = "quarter";

            } else if (amountNeeded >= 0.1 && dimes.getQuantityOnHand() > 0) {
                amountAdjustment = 0.1f;
                dimes.decreaseQuantity(1);
                coinString = "dime";

            } else if (amountNeeded >= 0.05 && nickels.getQuantityOnHand() > 0) {
                amountAdjustment = 0.05f;
                nickels.decreaseQuantity(1);
                coinString = "nickel";

            } else if (amountNeeded >= 0.01 && pennies.getQuantityOnHand() > 0) { 
                amountAdjustment = 0.01f;
                pennies.decreaseQuantity(1);              
                coinString = "penny";

            } else {
                changeGiven = false;
                
            }         

            if (changeGiven) {
                if (amountAdjustment >= 1) { 
                    System.out.println("Give them a $"+(int)(amountAdjustment)+" note");
                } else {
                    System.out.println("Give them a "+coinString);
                }
                amountNeeded -= amountAdjustment;
            
            } else if (compositeTotal(allNotes, allCoins) <= 0.00f) {
                System.out.println("I don't have enough money. I still owe you $"+String.format("%4.2f", amountNeeded));

            }
        
        } while (changeGiven);
        compositeWeight(allCoins);
        System.out.println("I have $"+String.format("%4.2f", compositeTotal(allNotes, allCoins))+" left, it's total weight is "+ (compositeWeight(allCoins) < 0.0009 ? "0" : String.format("%4.3f", compositeWeight(allCoins))) +"oz");
        input.close();
    }
}
