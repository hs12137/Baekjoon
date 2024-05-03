import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q_2667 {

    static char[][] matrix;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        matrix = new char[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j+1] = arr[j];
            }
        }
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        while(true){
            int[] start = search();
            if(start == null) break;
            list.add(dfs(start[0], start[1]));
            answer++;
        }
        Collections.sort(list);
        for (Integer i : list) {
            sb.append("\n").append(i);
        }
        System.out.println(answer + sb.toString());
    }
    private static int[] search(){
        int[] info = new int[2];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    info[0] = i;
                    info[1] = j;
                    return info;
                }
            }
        }
        return null;
    }
    private static int dfs(int i, int j){
        visited = new boolean[matrix.length][matrix[0].length];
        count = 1;
        matrix[i][j] = '0';
        doDfs(i, j);
        return count;
    }
    private static void doDfs(int i, int j){
        for(int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if (matrix[x][y] == '1'){
                count++;
                matrix[x][y] = '0';
                doDfs(x, y);
            }
        }
    }
}
