import java.util.Scanner;
import java.text.DecimalFormat;

class phoneBill {
    public static void main(String[] args) {
        // Welcome and set up
        System.out.println("Phone Bill Activity!");
        Scanner input = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("#.##");

        // Package input
        System.out.println("Which package are you subscribed to? Green, Blue, or Purple?");
        String subscriptionPackage = input.nextLine().toLowerCase();

        // Package error checking
        while (!subscriptionPackage.equals("green") && !subscriptionPackage.equals("blue") && !subscriptionPackage.equals("purple")) {
            System.out.println("Error. Invalid input. Please try again.");
            System.out.println("Which package are you subscribed to? Green, Blue, or Purple?");
            subscriptionPackage = input.nextLine().toLowerCase();
        }

        System.out.println("How much data did you use this month?");
        double dataUsed = input.nextDouble();

        // Calculations
        double cost = 0;

        if (subscriptionPackage.equals("green")) {
            cost += 49.99;
            dataUsed -= 2;
            cost += (15*dataUsed);

            System.out.println("Do you have a coupon? Y/N");
            String coupon = input.next().toLowerCase();
            if (coupon.equals("y") && cost >= 75) {
                cost -= 20;
            }
        }
        else if (subscriptionPackage.equals("blue")) {
            cost += 70;
            dataUsed -= 4;
            cost += (10*dataUsed);
        }
        else {
            cost += 99.95;
        }

        // Output
        System.out.println("Your monthly bill total is: $" + moneyFormat.format(cost));

    }
}