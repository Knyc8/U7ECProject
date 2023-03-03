public class PostageCalculator {
    private static final double BASE_PRICE = 3.75;

    public static double calculatePostage(String zip1, String zip2, double weight, double height, double length, double width)
    {
        double cost = 3.75;
        double combined = height + length + width;
        if (combined > 36) {
            double perInch = 0.1 * (int)(combined-36);
            cost += perInch;
        }
        if (weight > 40)
        {
            double perTenthPound = 0.05 * (int) (40 / (0.1));
            cost += perTenthPound;
            perTenthPound = 0.1 * (int)(((weight)-40) /0.1);
            cost += perTenthPound;
        }
        else
        {
            double perTenthPound = 0.05 * (weight / (0.1));
            cost += perTenthPound;
        }
        int cc1 = Integer.parseInt(zip1.substring(0, 3));
        int cc2 = Integer.parseInt(zip2.substring(0, 3));

        double ccDiff = Math.abs(cc1 - cc2);
        ccDiff /= 100;
        cost += ccDiff;
        return cost;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double height, double length, double width)
    {
        double cost = BASE_PRICE;
        double combined = height + length + width;
        if (combined > 36) {
            double perInch = 0.1 * (int)(combined-36);
            cost += perInch;
        }
        if (weight > 40)
        {
            double perTenthPound = 0.05 * (int) (40 / (0.1));
            cost += perTenthPound;
            perTenthPound = 0.1 * (int)(((weight)-40) /0.1);
            cost += perTenthPound;
        }
        else
        {
            double perTenthPound = 0.05 * (int) (weight / (0.1));
            cost += perTenthPound;
        }
        double ccDiff = Math.abs(origin.getCountryCode() - destination.getCountryCode());
        ccDiff /= 100;
        cost += ccDiff;
        return cost;
    }

    public static double calculatePostage(Package pack)
    {
        double cost = BASE_PRICE;
        double combined = pack.getHeight() + pack.getLength() + pack.getWidth();
        if (combined  > 36) {
            double perInch = 0.1 * (int)(combined-36);
            cost += perInch;
        }
        if (pack.getWeight() > 40)
        {
            double perTenthPound = 0.05 * (int) (40 / (0.1));
            cost += perTenthPound;
            perTenthPound = 0.1 * (int)(((pack.getWeight())-40) /0.1);
            cost += perTenthPound;
        }
        else
        {
            double perTenthPound = 0.05 * (int) (pack.getWeight() / (0.1));
            cost += perTenthPound;
        }
        double ccDiff = Math.abs(pack.getDestination().getCountryCode() - pack.getOrigin().getCountryCode());
        ccDiff /= 100;
        cost += ccDiff;
        return cost;
    }
}
