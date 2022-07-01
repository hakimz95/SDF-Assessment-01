package task01;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String csvFile = null;
        String templateFile = null;

        if(args[0].equals("thankyou.csv") && args[1].equals("thankyou.txt")) {
            csvFile = "./src/main/java/vttp2022/assessment/task01/data/thankyou.csv";
            templateFile = "./src/main/java/vttp2022/assessment/task01/template/thankyou.txt";

            try (
            Reader reader = Files.newBufferedReader(Paths.get(csvFile));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            ) {
                //Reading the csv file one by one in a String array
                String[] thankyou;
                while ((thankyou = csvReader.readNext()) != null) {
                    System.out.println("First Name: " + thankyou[0]);
                    System.out.println("Last Name: " + thankyou[1]);
                    System.out.println("Address: " + thankyou[2]);
                    System.out.println("Years: " + thankyou[3]);
                    System.out.println("\n");
                }
            }
        }

        if(args[0].equals("tour_package.csv") && args[1].equals("tour_package.txt")) {
            csvFile = "./src/main/java/vttp2022/assessment/task01/data/tour_package.csv";
            templateFile = "./src/main/java/vttp2022/assessment/task01/template/tour_package.txt";

            try (
            Reader reader = Files.newBufferedReader(Paths.get(csvFile));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            ) {
                //Reading the csv file one by one in a String array
                String[] tourPackage;
                while ((tourPackage = csvReader.readNext()) != null) {
                    System.out.println("First Name: " + tourPackage[0]);
                    System.out.println("Last Name: " + tourPackage[1]);
                    System.out.println("Address: " + tourPackage[2]);
                    System.out.println("Years: " + tourPackage[3]);
                    System.out.println("\n");
                }
            }
        }
    }
}
