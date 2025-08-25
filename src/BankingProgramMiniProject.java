import java.util.Scanner;

public class BankingProgramMiniProject {
    public static void main(String[] args) {

        //Variables
        Scanner scanner = new Scanner(System.in);
        int choice;
        double balance =  0;

        do{
            //Display menu and get user input.
            menu();
            choice = scanner.nextInt();

            //Validify input.
            while(choice > 4 || choice < 1){
                System.out.print("Invalid choice, please enter (1-4): ");
                choice = scanner.nextInt();
            }

            switch(choice){
                case 1 -> showBalance(balance, scanner);
                case 2 -> balance = deposit(balance, scanner);
                case 3 -> balance = withdraw(balance, scanner);
                case 4 -> {
                    System.out.print("Exiting");
                    try{
                        for(int i = 0; i < 3; i++){
                            Thread.sleep(275);
                            System.out.print(".");
                        }
                    }catch(Exception ignored){}
                }
                default -> System.out.println("error");
            }

        }while(choice != 4);

        scanner.close();
    }

    static void menu() {
        System.out.print("***************\n" +
                "BANKING PROGRAM\n" +
                "***************\n" +
                "1. Show Balance\n" +
                "2. Deposit\n" +
                "3. Withdraw\n" +
                "4. Exit\n" +
                "***************\n" +
                "Enter your choice (1-4): ");
    }

    static void showBalance(double balance, Scanner scanner){
        System.out.printf("\n\nYour balance is %.2f\n", balance);
        System.out.println("Press any key for menu.");
        scanner.nextLine();
        String anyKey = scanner.nextLine();
    }

    static double deposit(double balance, Scanner scanner){
        System.out.print("\n\nEnter deposit amount: ");
        scanner.nextLine();
        double amount = scanner.nextDouble();
        if(amount < 0){
            System.out.println("Amount can't be negative.");
            System.out.println("Press enter for menu.");
            scanner.nextLine();
            String choice = scanner.nextLine();
        }else{
        balance += amount;
        System.out.println("Succesfully deposited, press enter for menu.");
        scanner.nextLine();
        String choice = scanner.nextLine();
        }
        return balance;
    }

    static double withdraw(double balance, Scanner scanner){
        System.out.print("\n\nEnter the amount to withdraw: ");
        scanner.nextLine();
        double amount = scanner.nextDouble();

        if(amount > balance){
            System.out.println("INSUFFICIENT FUNDS");
            System.out.println("Press enter for menu.");
            scanner.nextLine();
            String choice = scanner.nextLine();
        }
        else if(amount < 0) {
            System.out.println("Amount can't be negative.");
            System.out.println("Press enter for menu.");
            scanner.nextLine();
            String choice = scanner.nextLine();
        }else {
            balance -= amount;
            System.out.println("Succesfully withdrawn, press enter for menu.");
            scanner.nextLine();
            String choice = scanner.nextLine();
        }
        return balance;
    }
}