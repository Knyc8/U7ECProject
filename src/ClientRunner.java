import java.sql.SQLOutput;
import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("4")) {
            System.out.print("""
                --------------------------------------------------
                What would you like to do?
                1. Calculate cost of one package
                2. Simulate packages
                3. How package costs are calculated
                4. Exit
                """);
            System.out.print("Input: ");
            choice = s.nextLine();
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
                clearScreen();
                System.out.print("""
                        ------------------------------------------------
                        What would you like to do?
                        1. Calculate cost of one package
                        2. Simulate packages
                        3. How package costs are calculated
                        4. Exit
                        """);
                System.out.print("Input: ");
                choice = s.nextLine();
            }
            System.out.println("------------------------------------------------");

            if (choice.equals("1")) {
                System.out.print("Enter the zip code of the origin package: ");
                String ogZip = s.nextLine();
                System.out.print("Enter the zip code of the destination package: ");
                String desZip = s.nextLine();
                System.out.print("Enter the weight of the package: ");
                Double weight = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package: ");
                Double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package: ");
                Double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package: ");
                Double width = Double.parseDouble(s.nextLine());

                Double cost = PostageCalculator.calculatePostage(ogZip, desZip, weight, height, length, width);
                System.out.printf("Cost: $%.2f", cost);
            }
            if (choice.equals("2")) {
                System.out.print("How many packages would you like to simulate? ");
                int numGen = Integer.parseInt(s.nextLine());
                PackageSimulator.generatePackages(numGen);
                System.out.println("Randomly generated packages info: ");
                System.out.println(PackageSimulator.getSimulationInfo());
            }
            if (choice.equals("3")) {
                System.out.println("""
                        How packages are calculated:
                        - The program takes in the zipcodes of the origin and the destination, the weight
                          of the package, and the dimensions of the package.
                        - Packages start with a base cost of $3.75.
                        - For each tenth of a pound, $0.05 is added to the base cost.
                        - To calculate the final cost, the positive difference between the first three
                          digits of both zipcodes are divided by 100 and subsequently added to the total cost.

                        If the package is above a combined 36 inches:
                        - For packages above a combined 36 inches (h + l + w), an additional $0.10 is added
                          to the final cost for each inch above 36in.

                        If the package is above the 40lb limit:
                        - For packages above the 40lb limit, an additional $0.10 is added for every tenth 
                          of a pound above the weight limit.
                        """);
            }
            if (choice.equals("4")) {
                System.out.println("Successfully exited the menu.");
            }
        }
    }

    public static void clearScreen()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }
}
