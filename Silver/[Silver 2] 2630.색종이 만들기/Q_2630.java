import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2630 {

    static int[][] arr;
    static int white, blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        white = 0;
        blue = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int l = 0; l < n; l++) arr[i][l] = Integer.parseInt(st.nextToken());
        }
        detect(0, 0, n);
        System.out.println(white + "\n" + blue);
    }
    private static void detect(int x, int y, int len){
        if(len == 1 || check(x, y, len)){
            if(arr[x][y] == 1) blue++;
            else white++;
            return;
        }
        detect(x, y, len / 2);
        detect(x + (len / 2), y, len / 2);
        detect(x, y + (len / 2), len / 2);
        detect(x + (len / 2), y + (len / 2), len / 2);
    }
    private static boolean check(int x, int y, int len){
        int color = arr[x][y];
        for(int i = x; i < x + len; i++){
            for(int l = y; l < y + len; l++){
                if(arr[i][l] != color) return false;
            }
        }
        return true;
    }
}