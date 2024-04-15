package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q_1012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] d_x = {1, -1, 0, 0};
		int[] d_y = {0, 0, 1, -1};
		for(int i = 0; i < n; i++) {
			int[] farmInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			boolean[][] farm = new boolean[farmInfo[0]][farmInfo[1]];
			Queue<int[]> queue = new LinkedList<>();
			int[][] coordinates = new int[farmInfo[2]][2];
			int answer = 0;
			for(int l = 0; l < farmInfo[2]; l++) {
				int[] coordinate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				farm[coordinate[0]][coordinate[1]] = true;
				coordinates[l][0] = coordinate[0];
				coordinates[l][1] = coordinate[1];
			}
			for(int[] coord : coordinates) {
				if(farm[coord[0]][coord[1]] == true) {
					queue.add(coord);
					farm[coord[0]][coord[1]] = false;
					answer++;
				}
				while(!queue.isEmpty()) {
					int[] target = queue.poll();
					for(int m = 0; m < d_x.length; m++) {
						int x = target[0] + d_x[m];
						int y = target[1] + d_y[m];
						if(x >= 0 && x < farmInfo[0] && y >= 0 && y < farmInfo[1]) {
							if(farm[x][y]) {
								int[] addCoord = {x, y};
								farm[x][y] = false;
								queue.add(addCoord);
							}
						}
					}
				}
			}
			System.out.println(answer);
		}
	}
}