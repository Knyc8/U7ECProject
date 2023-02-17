import java.sql.SQLOutput;
import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("""
                --------------------------------------------------
                What would you like to do?
                1. Calculate cost of one package
                2. Simulate packages
                3. How package costs are calculated
                4. Exit
                """);
        System.out.print("Input: ");
        String choice = s.nextLine();
        while (!choice.equals("1") &&  !choice.equals("2") && !choice.equals("3") && !choice.equals("4"))
        {
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

        if (choice.equals("1"))
        {
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
        if (choice.equals("2"))
        {

        }
        if (choice.equals("4"))
        {
            System.out.println("Successfully exited the menu.");
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
