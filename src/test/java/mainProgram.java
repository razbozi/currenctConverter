import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class mainProgram {
    public static void main(String[] args) throws Exception {

        String response = null;
        double result;
        List<Double> results = new ArrayList<>();
        File resultsFile = new File("results.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile));
        USD usd = new USD();
        ILS ils = new ILS();
        EUR eur = new EUR();

        // First screen appearance:
        System.out.printf("Welcome to currency converter %n");

        do {
            System.out.printf("Please choose an option (1/2/3): %n" +
                    "1.Dollars to Shekels %n" +
                    "2.Shekels to Dollars %n" +
                    "3.Euros to Shekels %n");
            // user input definition
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            // while statement in case wrong input is entered
            try {
                while (choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("Invalid choice, please try again");
                    choice = input.nextInt();
                }
                // if statement for user choice
                if (choice == 1) {
                    System.out.println("Please enter Dollar  amount to convert to Shekel");
                    result = usd.calculate(input.nextDouble());
                    System.out.printf("Your amounts in Shekels are " + result + "%n");
                    results.add(result);

                } else if (choice == 2) {
                    System.out.println("Please enter Shekel amount to convert to Dollar");
                    result = ils.calculate(input.nextDouble());
                    System.out.printf("Your amounts in Dollar are %.2f\n", result);
                    results.add(result);

                } else if (choice == 3) {
                    System.out.println("Please enter Shekel amount to convert to Euro");
                    result = eur.calculate(input.nextDouble());
                    System.out.printf("Your amounts in Shekels are %.2f\n" , result);
                    results.add(result);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Do you want to start over? Y/N");
            response = keyboard.next();


            // while statement in case wrong response  is entered
            try {
                while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                    System.out.println("Invalid response. Try again.");
                    response = keyboard.next();
                }
                // if statement for user input Y/N
                if (response.equalsIgnoreCase("n")) {
                    System.out.println("Thanks for using our currency converter!");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (response.equalsIgnoreCase("y"));
        System.out.println("Your conversion results are: " + results);

        writer.write(String.valueOf(results));
        writer.close();
    }
}