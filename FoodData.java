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
        double juiceWins = 0;
        double nonJuiceWins = 0;
        double counter = 0;

        while (sc.hasNextLine()) {
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            if (Double.parseDouble(line.get(ageIndex)) <  40 && line.get(drinkIndex).equals("Fresh Juice")) {
                juiceWins ++;
                counter ++;

            }
            else {
                nonJuiceWins ++;
                counter ++;
            }
        }
   
        double juiceAvg = juiceWins/counter;
        double nonJuiceAvg = nonJuiceWins/counter;
        if (juiceAvg > nonJuiceAvg) {
            System.out.println(String.format("People under the age of 40 are more likely to prefer juice being around %.2f%s", (juiceAvg*100), "%"));

        }
        else {
            System.out.println(String.format("People under the age of 40 are more likely to prefer juice being around %.2f%s", (nonJuiceAvg*100), "%"));
        }

        
    }  
    
}


