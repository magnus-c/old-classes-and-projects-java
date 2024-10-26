import java.text.NumberFormat;
import java.util.ArrayList;


public class Total {
    static double total = 0;
    public static double getTotal(ArrayList<Double> weeklyRates){
        for (Double d : weeklyRates) {
                total += d;
        }
        return total;
    }
    public static String formatTotal(double total){
        
        String totalLine = String.format("TOTAL: $%1.2f", total);
        return totalLine;
    }
}
