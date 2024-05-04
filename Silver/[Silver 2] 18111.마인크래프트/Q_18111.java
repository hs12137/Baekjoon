import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int min = 256;
        int max = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int l = 0; l < m; l++){
                int h = Integer.parseInt(st.nextToken());
                arr[i][l] = h;
                min = Math.min(min, h);
                max = Math.max(max, h);
            }
        }
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        for(int i = min; i <= max; i++){
            int needBlock = 0;
            int time = 0;
            for(int[] line : arr){
                for(int block : line){
                    int diff = block - i;
                    if (diff < 0) {
                        needBlock += diff;
                        time -= diff;
                    }
                    else if (diff > 0){
                        needBlock += diff;
                        time += diff * 2;
                    }
                }
            }
            if(b + needBlock < 0) continue;
            if(time <= answerTime){
                answerTime = time;
                answerHeight = i;
            }
        }
        System.out.println(answerTime + " " + answerHeight);
    }
}
