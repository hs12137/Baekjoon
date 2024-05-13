import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = Arrays.stream(Arrays.copyOf(arr, arr.length))
                .distinct()
                .sorted()
                .toArray();
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int num : sorted) {
            if(!map.containsKey(num)) map.put(num, index++);
        }
        for(int num : arr) sb.append(" ").append(map.get(num));
        System.out.println(sb.substring(1));
    }
}