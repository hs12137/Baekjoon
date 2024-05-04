import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] list = new String[n + 1];
        for(int i = 1; i <= n; i++){
            String pokemon = br.readLine();
            map.put(pokemon, i);
            list[i] = pokemon;
        }
        for(int i = 0; i < m; i++){
            String input = br.readLine();
            try {
                sb.append(list[Integer.parseInt(input)]).append("\n");
            }catch (NumberFormatException e) {
                sb.append(map.get(input)).append("\n");
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}