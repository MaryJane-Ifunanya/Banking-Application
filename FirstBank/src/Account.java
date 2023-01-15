import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    
    }

    void deposit(int amount){
        if(amount != 0 ){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdaw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: "+ previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: "+ Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction took place.");
            
        }
    }

    void calculateInterest(int years){
        double interestRate = .0185;
        double newBalance = (balance * interestRate *years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, your balance will be: " + newBalance);

    }
    
    void showMenu(){
        char option = '\0';
        Scanner Scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("Welcome, \033[0;33m" + customerName +( "!\033[m"));
        System.out.println("Your ID is: " + customerID);
        System.out.println("======================================");
        System.out.println();
        System.out.println("\033[0;32mWhat would you like to do?\033[m");
        System.out.println();
        System.out.println("A - Check your balance");
        System.out.println("B - Make a deposit");
        System.out.println("C - Make a withdrawal");
        System.out.println("D - View previous transaction");
        System.out.println("E - Calculate interest");
        System.out.println("F - Exit");

        do{
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = Scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                case 'A':
                    System.out.println("=========================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("============================================");
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = Scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = Scanner.nextInt();
                    withdaw(amount2);
                    System.out.println();
                    break;

                case 'D':
                System.out.println("===========================================");
                getPreviousTransaction();
                System.out.println("============================================");
                System.out.println();
                break;

                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = Scanner.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("=============================================");
                    break;
                default:
                    System.out.println("\033[0;31mErro: invalid option. Please enter A, B, C, D, E, F\033[m");
                    break;
                }
            } while(option != 'F');
            System.out.println("\033[0;34mThank you for banking with us!\033[m");
        }
    }





