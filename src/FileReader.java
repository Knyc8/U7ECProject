import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> genZip() {
        ArrayList<String> zipcodes = new ArrayList<String>();
        try {
            File zipData = new File("src/USzipcodes.txt");
            Scanner reader = new Scanner(zipData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(",");
                if (data.length > 1) {
                    String z = data[0];
                    zipcodes.add(z);
                }

            }
        }
        catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return zipcodes;
    }
}
