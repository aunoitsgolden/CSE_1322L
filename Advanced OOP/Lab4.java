import java.util.*;

class Account {

    private static int account_number = 10000; 
    private float account_balance;

    public Account() {
        account_balance = 0;
        account_number++;
    }

    public Account(float account_balance) {
        this.account_balance = account_balance;
        account_number++;
    }

    public int getAccountNumber() {
        return account_number;
    }

    public float getAccountBalance() {
        return account_balance;
    }

    public void setAccountBalance(float account_balance) {
        this.account_balance = account_balance;
    }

    public void withdrawal(float amount) {
        account_balance -= amount;
    }

    public void deposit(float amount) {
        account_balance += amount;
    }

}

class Checking extends Account {

    public Checking(float account_balance) { // (float account_balance) {
        super.account_number;
    }

    @Override
    public void withdrawal(float amount) {
        if (getAccountBalance() - amount < 0) {
            System.out.println("Charging an overdraft fee of $20 because your account is below $0");
            super.withdrawal(amount + 20);
        } else {
            super.withdrawal(amount);
        }
    }

}

class Savings extends Account {

    private int deposit_occurence;

    public Savings(float account_balance) {
        super();
        deposit_occurence = 0;
    }

    @Override
    public void withdrawal(float amount) {
        if (getAccountBalance() - amount < 500) {
            System.out.println("Charging a fee of $10 because your account is below $500");
            super.withdrawal(amount + 10); 
        } else {
            super.withdrawal(amount);
        }
    }

    @Override
    public void deposit(float amount) {
        deposit_occurence++;
        super.deposit(amount);

        if (deposit_occurence <= 5) {
            System.out.println("This is deposit "+deposit_occurence+" to this account");
        } else {
            System.out.println("Charging a fee of $10");
            withdrawal(10); // keeping the this.withdrawal because if the account goes below $500 we still want the $10 fee
        }
    }

    public void awardInterest() {
        float interest_earned = getAccountBalance() * 0.015f;
        System.out.println("Customer earned "+interest_earned+" in interest");
        super.deposit(interest_earned); // using super.deposit because we don't want to increment occurence
    }
}

public class Lab4 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Checking newChecking = new Checking(100); // 10001
        Savings newSavings = new Savings(600); // 10002
        int menuInput;

        do {
            System.out.println("1. Withdraw from Checking"
                            +"\n2. Withdraw from Savings"
                            +"\n3. Deposit to Checking"
                            +"\n4. Deposit to Savings"
                            +"\n5. Balance of Checking"
                            +"\n6. Balance of Savings"
                            +"\n7. Award Interest to Savings now"
                            +"\n8. Quit"
            );
            menuInput = input.nextInt();
            input.nextLine();

            switch (menuInput) {
                case 1:
                    System.out.println("How much would you like to withdraw from Checking?");
                    newChecking.withdrawal(input.nextFloat());
                    break;

                case 2: 
                    System.out.println("How much would you like to withdraw from Savings?");
                    newSavings.withdrawal(input.nextFloat());
                    break;

                case 3: 
                    System.out.println("How much would you like to deposit into Checking?");
                    newChecking.deposit(input.nextFloat());
                    break;

                case 4:
                    System.out.println("How much would you like to deposit into Savings?");
                    newSavings.deposit(input.nextFloat());
                    break;

                case 5:
                    System.out.println("Your balance for checking "+newChecking.getAccountNumber()+" is "+newChecking.getAccountBalance());
                    break;

                case 6:
                    System.out.println("Your balance for savings "+newSavings.getAccountNumber()+" is "+newSavings.getAccountBalance());
                    break;

                case 7:
                    newSavings.awardInterest();
                    break;

            }

        } while (menuInput != 8);
        input.close();
    }
}
