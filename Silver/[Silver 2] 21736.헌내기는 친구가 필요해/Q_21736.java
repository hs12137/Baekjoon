import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_21736 {

    static char[][] school;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        school = new char[N+2][M+2];
        visited = new boolean[N+2][M+2];
        int startY = 0;
        int startX = 0;
        for(int i = 1; i <= N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int l = 1; l <= M; l++) {
                school[i][l] = arr[l - 1];
                if(arr[l-1] == 'I') {
                    startY = i;
                    startX = l;
                }
            }
        }
        visited[startY][startX] = true;
        search(startY, startX);
        System.out.println(answer > 0 ? answer : "TT");
    }
    private static void search(int startY, int startX){
        for(int i = 0; i < 4; i++) {
            int y = startY + dy[i];
            int x = startX + dx[i];
            if(!visited[y][x]){
                if(school[y][x] == 'O') {
                    visited[y][x] = true;
                    search(y, x);
                }else if (school[y][x] == 'P') {
                    answer++;
                    visited[y][x] = true;
                    search(y, x);
                }
            }
        }
    }
}