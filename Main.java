import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        float amount_owed,interest_rate, monthly_payment;
         
        System.out.println("Balance owed");
        Scanner sc = new Scanner(System.in);
        amount_owed = sc.nextFloat();
        System.out.println("Annual interest Rate:");
        Scanner ic= new Scanner(System.in);
        interest_rate = ic.nextFloat();
        System.out.println("Monthly Payment");
        Scanner mc = new Scanner(System.in);
        monthly_payment = mc.nextFloat();
        int num= (int)(amount_owed/ monthly_payment) +1;
       
        float month_rate = interest_rate /1200;
        int years = num % 12;
        double balance, principal, interest;
        balance = amount_owed;
        for (int i = 1; i <= num; i++) {
          interest = month_rate * balance;

          principal = monthly_payment - interest;
          if(principal>=balance){ principal= balance;}
          System.out.println("Month     Balance     Payment     Principal     Interest");
          System.out.printf("%-13d%-13.2f%-13.2f%-13.2f%.2f\n", i, balance,monthly_payment,
              principal, interest);
              balance = balance - principal;
             
      }
    
    } 
        
}
