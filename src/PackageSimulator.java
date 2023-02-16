import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public void generatePackages(int numGen)
    {

    }

    public double generateTotalCost()
    {
        double totalCost = 0.0;
        for (Package pack : packages)
        {
            totalCost += PostageCalculator.calculatePostage(pack);
        }
        return totalCost;
    }

    public void resetSimulation()
    {
        packages = new ArrayList<>();
    }
}
