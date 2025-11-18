import java.io.*;
import java.util.*;
public class FoodData {
    public static void main (String [] args) throws FileNotFoundException {
        juiceForAge("/Users/areid/Desktop/CS_SEMINAR/DataSetProject/Food_Preference.csv");

    }
    public static void juiceForAge (String pathname) throws FileNotFoundException {
        File f = new File(pathname);
        Scanner sc = new Scanner(f);

        String [] header = sc.nextLine().split(",");
        int ageIndex = 4;
        int drinkIndex = 6;
        // ArrayList<Double> juiceWins = new ArrayList<>();
        // ArrayList<Double> nonJuiceWins = new ArrayList<>();
        double juiceWins = 0;
        double nonJuiceWins = 0;
        double counter = 0;

        while (sc.hasNextLine()) {
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            if (Double.parseDouble(line.get(ageIndex)) <  40 && line.get(drinkIndex).equals("Fresh Juice")) {
                // juiceWins.add(String.parseString(line.get(drinkIndex)));
                juiceWins ++;
                counter ++;

            }
            else {
                // nonJuiceWins.add(String.parseDouble(line.get(drinkIndex)));
                nonJuiceWins ++;
                counter ++;
            }
        }
   
        double juiceAvg = juiceWins/counter;
        double nonJuiceAvg = nonJuiceWins/counter;
        if (juiceAvg > nonJuiceAvg) {
            System.out.println("Around " + juiceAvg + " of people under the age of 40 DO prefer fresh juice");
            System.out.println("That is more than people under the age of 40 who DO NOT prefer juice which is around " + nonJuiceAvg);

        }
        else {
            System.out.println("Around " + nonJuiceAvg + " of people under the age of 40 DO NOT prefer fresh juice");
            System.out.println("That is more than people under the age of 40 who DO prefer juice which is around " + juiceAvg);
        }

        
    }  
    
}


