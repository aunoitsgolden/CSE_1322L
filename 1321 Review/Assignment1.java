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

        System.out.println(twenties);
        System.out.println(tens);
        System.out.println(fives);
        System.out.println(ones);
        System.out.println(quarters);
        System.out.println(dimes);
        System.out.println(nickels);
        System.out.println(pennies);

        float compositeTotal = ( // make to method
            twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + 
            ones.getTotalValue() + quarters.getTotalValue() + dimes.getTotalValue() + 
            nickels.getTotalValue() + pennies.getTotalValue()
        );
        float compositeWeight = ( // make to method
            quarters.getTotalWeight() + dimes.getTotalWeight() + nickels.getTotalWeight() + 
            pennies.getTotalWeight()
        );
        System.out.println("Total money is "+ "$"+ String.format("%4.2f", compositeTotal) + " total weight is "+ compositeWeight +"oz."); // is it better make print pretty a method?

        System.out.print("How much do you need? ");
        float amountNeeded = input.nextFloat();

        while (amountNeeded != 0) {
            float amountAdjustment = 0;
            // this is interesting, it can be easily unresourceful and go by 1, or we can find an alternative approach...
            // try... so can be chosenCurrency.decreaseQuantity and -= chosenQuantity.denomination
            // Can't do: switch (float)            

            if (amountNeeded > 20 && twenties.getTotalValue() > 0) {
                amountAdjustment = 20;
                twenties.decreaseQuantity(1);

            } else if (amountNeeded > 10 && tens.getTotalValue() > 0) {
                amountAdjustment = 10;
                tens.decreaseQuantity(1);

            } else if (amountNeeded > 5 && fives.getTotalValue() > 0) {
                amountAdjustment = 5;
                fives.decreaseQuantity(1);

            } else if (amountNeeded > 1 && ones.getTotalValue() > 0) {
                amountAdjustment = 1;
                ones.decreaseQuantity(1);

            } else if (amountNeeded > 0.25 && quarters.getTotalValue() > 0) {
                amountAdjustment = 0.25f;
                quarters.decreaseQuantity(1);

            } else if (amountNeeded > 0.1 && dimes.getTotalValue() > 0) {
                amountAdjustment = 0.1f;
                dimes.decreaseQuantity(1);

            } else if (amountNeeded > 0.05 && nickels.getTotalValue() > 0) {
                amountAdjustment = 0.05f;
                nickels.decreaseQuantity(1);
            
            } else if (amountNeeded > 0.01 && pennies.getTotalValue() > 0) { 
                amountAdjustment = 0.01f;
                pennies.decreaseQuantity(1);              
            } else {
                amountNeeded = 0;
            } 
            if (amountNeeded > 0) {
                System.out.println("Give them a "+String.format("%4.2f", amountAdjustment)+" ");
                amountNeeded -= amountAdjustment;
            }
        }

        compositeTotal = ( // make to method
            twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + 
            ones.getTotalValue() + quarters.getTotalValue() + dimes.getTotalValue() + 
            nickels.getTotalValue() + pennies.getTotalValue()
        );
        compositeWeight = ( // make to method
            quarters.getTotalWeight() + dimes.getTotalWeight() + nickels.getTotalWeight() + 
            pennies.getTotalWeight()
        );
        System.out.println("Total money is "+ "$"+ String.format("%4.2f", compositeTotal) + " total weight is "+ compositeWeight +"oz."); // is it better make print pretty a method?

        input.close();
    }
}
