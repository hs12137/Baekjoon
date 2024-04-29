import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q_20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if(input.length() < m) continue;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        Node[] arr = new Node[map.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[index++] = new Node(entry.getKey(), entry.getValue());
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.count != o2.count) return o2.count - o1.count;
                else if(o1.value.length() != o2.value.length()) return o2.value.length() - o1.value.length();
                else return o1.value.compareTo(o2.value);
            }
        });
        for(Node node : arr) {
            sb.append("\n").append(node.value);
        }
        System.out.println(sb.substring(1));
    }
    private static class Node{
        String value;
        int count;
        public Node(String key, Integer value) {
            this.value = key;
            this.count = value;
        }
    }
}