import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q_10026 {

    static boolean[][] visited1;
    static boolean[][] visited2;
    static char[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new char[n+2][n+2];
        visited1 = new boolean[n+2][n+2];
        visited2 = new boolean[n+2][n+2];
        int answer1 = 0, answer2 = 0;
        for (int i = 1; i <= n; i++) {
            int index = 1;
            for (char c : br.readLine().toCharArray()) {
                matrix[i][index++] = c;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited1[i][j]) {
                    answer1++;
                    bfs1(i, j);
                }
                if (!visited2[i][j]) {
                    answer2++;
                    bfs2(i, j);
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
    static void bfs1(int i, int j) {
        char start = matrix[i][j];
        visited1[i][j] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if (matrix[nx][ny] == start && !visited1[nx][ny]) {
                    visited1[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }
    static void bfs2(int i, int j) {
        char start = matrix[i][j];
        visited2[i][j] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        if (start == 'B'){
            while (!q.isEmpty()) {
                Node node = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = node.x + dx[k];
                    int ny = node.y + dy[k];
                    if (matrix[nx][ny] == start && !visited2[nx][ny]) {
                        visited2[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        } else {
            while (!q.isEmpty()) {
                Node node = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = node.x + dx[k];
                    int ny = node.y + dy[k];
                    if ((matrix[nx][ny] == 'R' || matrix[nx][ny] == 'G') && !visited2[nx][ny]) {
                        visited2[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
