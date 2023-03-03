import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageSimulator {
    private static ArrayList<Package> packages = new ArrayList<Package>();

    public static void generatePackages(int numGen)
    {
        //maximum dimensions of a first-class package according to shippingschool.com (22" x 18" x 15")
        //minimum is set to the minimum allowed in the doc (at least 2 inches and at least 0.1lb)
        for (int i = 0; i < numGen; i++) {
            double height = Math.random() * (22 - 2) + 2;
            double length = Math.random() * (18 - 2) + 2;
            double width = Math.random() + (15 - 2) + 2;
            double weight = Math.random() * (70 - 0.1) + 0.1;
            String zip1 = FileReader.genZip().get((int) (Math.random()*FileReader.genZip().size()));
            String zip2 = FileReader.genZip().get((int) (Math.random()*FileReader.genZip().size()));
            while (zip1.equals(zip2))
            {
                zip2 = FileReader.genZip().get((int) (Math.random()*FileReader.genZip().size()));
            }
            Address origin = new Address("123 Random Street Apt 3C, City, State " + zip1);
            Address destination = new Address("123 Random Street Apt 3C, City, State " + zip2);
            Package pack = new Package(origin, destination, weight, height, length, width);
            packages.add(pack);
        }
    }

    public static double generateTotalCost()
    {
        double totalCost = 0.0;
        for (Package pack : packages)
        {
            totalCost += PostageCalculator.calculatePostage(pack);
        }
        return totalCost;
    }

    public static String getSimulationInfo()
    {
        String simFo = "";
        for (int i = 0; i < packages.size(); i++)
        {
            simFo += "Package " + (i+1) + ": ------------------------------------------------\n";
            simFo += "Origin address: " + packages.get(i).getOrigin() + "\n";
            simFo += "Destination address: " + packages.get(i).getDestination() + "\n";
            simFo += "Weight: " + packages.get(i).getWeight() + "\n";
            simFo += "Height: " + packages.get(i).getHeight() + "\n";
            simFo += "Length: " + packages.get(i).getLength() + "\n";
            simFo += "Width: " + packages.get(i).getWidth() + "\n";
        }
        simFo += "Cost: $" + String.format("%.2f", generateTotalCost());
        return simFo;
    }
    public static void resetSimulation()
    {
        packages.clear();
    }
}
