import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            map.clear();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 1) + 1);
            }
            int answer = 1;
            for (Integer num : map.values()) answer *= num;
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}