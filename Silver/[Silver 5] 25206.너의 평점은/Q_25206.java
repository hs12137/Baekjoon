import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_25206 {

    static Map<String, Double> map = new HashMap<String, Double>();
    public static void main(String[] args) throws IOException {
        mapInit();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalCredit = 0;
        double totalScore = 0;
        for(int i = 0; i < 20; i++){
            String[] input = br.readLine().split(" ");
            if(input[2].equals("P")) continue;
            double credit = Double.parseDouble(input[1]);
            totalCredit += credit;
            totalScore += map.get(input[2]) * credit;
        }
        System.out.println(totalScore / totalCredit);
    }
    public static void mapInit(){
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
    }
}
