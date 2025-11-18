import java.io.*;
import java.util.*;
public class FoodData {
    public static void main (String [] args) throws FileNotFoundException {
        //test function by adding food pathway
        juiceForAge("/Users/areid/Desktop/CS_SEMINAR/DataSetProject/Food_Preference.csv");

    }
    public static void juiceForAge (String pathname) throws FileNotFoundException {
        File f = new File(pathname);
        Scanner sc = new Scanner(f);

        String [] header = sc.nextLine().split(",");
        //make variables with index
        int ageIndex = 4;
        int drinkIndex = 6;
        double juiceWins = 0;
        double nonJuiceWins = 0;
        double counter = 0;

        while (sc.hasNextLine()) {
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            //see if they fall under the condition
            if (Double.parseDouble(line.get(ageIndex)) <  40 && line.get(drinkIndex).equals("Fresh Juice")) {
                //add to vars
                juiceWins ++;
                counter ++;

            }
            else {
                nonJuiceWins ++;
                counter ++;
            }
        }
   
        //find avg
        double juiceAvg = juiceWins/counter;
        double nonJuiceAvg = nonJuiceWins/counter;
        //print results
        if (juiceAvg > nonJuiceAvg) {
            System.out.println(String.format("People under the age of 40 are more likely to prefer juice being around %.2f%s", (juiceAvg*100), "%"));

        }
        else {
            System.out.println(String.format("People under the age of 40 are more likely to prefer juice being around %.2f%s", (nonJuiceAvg*100), "%"));
        }

        
    }  
    
}


