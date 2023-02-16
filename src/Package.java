public class Package {
    private Address origin;
    private Address destination;
    private double weight;
    private double length;
    private double height;
    private double width;

    public Package(Address o, Address d, double lb, double l, double h, double w)
    {
        origin = o;
        destination = d;
        weight = lb;
        length = l;
        height = h;
        width = w;
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return weight * length * height;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
