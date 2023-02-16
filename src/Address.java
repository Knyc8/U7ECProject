public class Address {
    private String streetNum;
    private String streetName;
    private String aptNum;
    private String city;
    private String state;
    private String zip;

    public Address(String stNum, String stName, String apt, String c, String s, String z)
    {
        streetNum = stNum;
        streetName = stName;
        aptNum = apt;
        city = c;
        state = s;
        zip = z;
    }

    public Address(Address address)
    {
        streetNum = address.getStreetNum();
        streetName = address.getStreetName();
        aptNum = address.getAptNum();
        city = address.getCity();
        state = address.getState();
        zip = address.getZip();
    }

    public Address(String address)
    {
        String temp = address;
        streetNum = temp.substring(0, temp.indexOf(" "));
        temp = temp.substring(temp.indexOf(" ") + 1);
        if (temp.indexOf("Apt") != -1) {
            streetName = temp.substring(0, temp.indexOf("Apt")-1);
            temp = temp.substring(temp.indexOf("Apt") + 4);
            aptNum = temp.substring(0, temp.indexOf(","));
            temp = temp.substring(temp.indexOf(",") + 2);
        }
        else
        {
            streetName = temp.substring(0, temp.indexOf(","));
            temp = temp.substring(temp.indexOf(",") + 2);
        }
        city = temp.substring(0, temp.indexOf(","));
        temp = temp.substring(temp.indexOf(",") + 2);
        state = temp.substring(0, temp.indexOf(" "));
        temp = temp.substring(temp.indexOf(" ") + 1);
        zip = temp;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAptNum() {
        return aptNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public int getCountryCode() {
        int countryCode =  Integer.parseInt(zip.substring(0, 3));
        return countryCode;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String toString()
    {
        if (aptNum != null)
        {
            return streetNum + " " + streetName + " Apt " + aptNum + ", " + city + ", " + state + " " + zip;
        }
        return streetNum + " " + streetName + ", " + city + ", " + state + " " + zip;
    }
}
