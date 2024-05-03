import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q_2573 {

    static int[][] matrix;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        while(true){
            int[] start = search(n-2, m-2);
            if(start[2] == 0){
                answer = 0;
                break;
            }
            if(dfs(n-2, m-2, start) == -1) break;
            answer++;
        }
        System.out.println(answer);
    }
    private static class Node{
        int x;
        int y;
        int melt;
        public Node(int x, int y, int melt) {
            this.x = x;
            this.y = y;
            this.melt = melt;
        }
    }
    private static int[] search(int height, int width){
        int[] res = new int[3];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i][j] != 0) {
                    res[0] = i;
                    res[1] = j;
                    res[2]++;
                }
            }
        }
        return res;
    }
    private static int dfs(int height, int width, int[] start) {
        visited = new boolean[height+2][width+2];
        count = 0;
        nodes.clear();
        visited[start[0]][start[1]] = true;
        doDfs(start[0], start[1]);
        if(nodes.size() != start[2]) return -1;
        for(Node node : nodes){
            matrix[node.x][node.y] = matrix[node.x][node.y] < node.melt? 0 : matrix[node.x][node.y] - node.melt;
        }
        return 1;
    }
    private static void doDfs(int x, int y){
        int melt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(matrix[nx][ny] > 0){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    doDfs(nx, ny);
                }
            }
            else melt++;
        }
        nodes.add(new Node(x, y, melt));
    }
}
