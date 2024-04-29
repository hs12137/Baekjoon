import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (String num : br.readLine().split(" ")) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        for (String num : br.readLine().split(" ")) {
            sb.append(" ").append(map.getOrDefault(num, 0));
        }
        System.out.println(sb.substring(1));
    }
}