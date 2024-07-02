import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][][] box = new boolean[m + 2][n + 2][h + 2];
        int tomato = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= m; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) queue.add(new Node(k, j, i, 0));
                    else if (input == 0) {
                        tomato++;
                        box[k][j][i] = true;
                    }
                }
            }
        }
        if (tomato == 0) {
            System.out.println(0);
            return;
        }
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {1, 0, -1, 0, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = node.x + dx[i], y = node.y + dy[i], z = node.h + dh[i];
                if (box[x][y][z]) {
                    box[x][y][z] = false;
                    tomato--;
                    queue.add(new Node(x, y, z, node.day + 1));
                }
            }
        }
        if (tomato > 0) System.out.println(-1);
        else System.out.println(node.day);
    }
    private static class Node{
        int x;
        int y;
        int h;
        int day;
        Node(int x, int y, int h, int day){
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
        }
    }
}
