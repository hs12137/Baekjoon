import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        Queue<Integer> values = new LinkedList<>();
        Queue<Boolean> wants = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            values.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            StringTokenizer input = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                if(j == x){
                    values.add(Integer.parseInt(input.nextToken()));
                    wants.add(true);
                }
                else {
                    values.add(Integer.parseInt(input.nextToken()));
                    wants.add(false);
                }
            }
            int count = 1;
            for (int j = 9; j >= 0; j--) {
                while(values.contains(j)){
                    int value = values.poll();
                    boolean want = wants.poll();
                    if(value == j){
                        if(want) sb.append("\n").append(count);
                        else count++;
                    }
                    else {
                        values.add(value);
                        wants.add(want);
                    }
                }
            }
        }
        System.out.println(sb.substring(1));
    }
}
