import java.util.ArrayList;

public class PackageSimulator {
    private static ArrayList<Package> packages;

    public static void generatePackages(int numGen)
    {

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
            simFo += "Package " + i+1 + ": ------------------------------------------------\n";
            simFo += "Origin address: " + packages.get(i).getOrigin() + "\n";
            simFo += "Destination address: " + packages.get(i).getDestination() + "\n";
            simFo += "Weight: " + packages.get(i).getWeight() + "\n";
            simFo += "Height: " + packages.get(i).getHeight() + "\n";
            simFo += "Length: " + packages.get(1).getLength() + "\n";
            simFo += "Width: " + packages.get(1).getWidth() + "\n";
        }
        simFo += "Cost: " + generateTotalCost();
        return simFo;
    }
    public static void resetSimulation()
    {
        packages.clear();
    }
}
