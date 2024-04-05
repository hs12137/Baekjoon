package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] total = new boolean[100][100];
		int answer = 0;
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]) - 1;
			int y = Integer.parseInt(s[1]) - 1;
			for(int l = x; l < x+10; l++) {
				for(int m = y; m < y+10; m++) {
					if(!total[l][m]) {
						total[l][m] = true;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
