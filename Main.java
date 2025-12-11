import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("---WELCOME TO KCB ACCOUNT CREATION---\n");
        int AccountNumber;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your account name: ");
        String AccountName = scan.nextLine();
        System.out.print("Enter your account number: ");
        AccountNumber = scan.nextInt();
        System.out.print("Set your pin: ");
        int AccountPin = scan.nextInt();





        BankAccount mine = new BankAccount(AccountName,0, AccountNumber,AccountPin);
        System.out.println("-----Account created successfully---\n");
        boolean running = true;
        while (running){
            System.out.println("\tMAIN MENU");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check balance");
            System.out.println("4.quit");



            System.out.print("\nreply with a number (1-4): ");
            int opt = scan.nextInt();

            if(opt == 1){
                System.out.print("\nEnter amount to deposit: ");
                double amt = scan.nextDouble();
                mine.deposit(amt);
            }
            else if(opt == 2){
                System.out.print("\nEnter amount to withdraw: ");
                double amt = scan.nextDouble();
                mine.withdraw(amt, scan);
            }
            else if(opt == 3){
                System.out.print("\nEnter your pin: ");
                int pin = scan.nextInt();
                System.out.println("your balance is "+mine.checkBalance(pin,scan));
            }
            else{

                running = false;
            }
        }
        scan.close();
    }
}
class BankAccount{
    int accountPin;
    String AccountName;
    double balance;
    int AccountNumber;
    BankAccount(String AccountName, double Initial_balance, int AccountNumber, int AccountPin){
        if (Initial_balance < 0){
            System.out.println("Initial balance cannot be negative");
            this.balance = 0;
        }
        else{
            this.balance = Initial_balance;
        }
        this.AccountName = AccountName;
        this.AccountNumber = AccountNumber;
        this.accountPin= AccountPin;
    }
    void deposit(double amount){
        balance += amount;
        System.out.println("your balance is now " + balance);
    }
    void withdraw(double amount, Scanner scan){

        System.out.print("Enter pin");
        int pin = scan.nextInt();


        while (pin != accountPin){
            System.out.println("incorrect pin");
            System.out.print("Enter pin");
            pin = scan.nextInt();
        }
        if(amount >= 0 && amount <= balance){
            balance -= amount;
            System.out.println("confirmed you have withdrawn "+ amount + "\nyour new balance is"+balance);
        }
        else if(amount > balance){
            System.out.println("insufficient funds");
        }

        else{
            System.out.println("amount cannot be negative");
        }


    }
    double checkBalance(int pin, Scanner scan){
        while (pin != accountPin) {
            System.out.println("Enter pin: ");
            pin = scan.nextInt();
        }
        return balance;
    }
}





