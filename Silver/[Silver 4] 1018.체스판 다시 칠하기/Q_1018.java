package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		char[][] arr = new char[n][m];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int answer = 64;
		for(int x = 0; x < n - 7; x++) {
			for(int y = 0; y < m - 7; y++) {
				int wrongNumStartB = 0;
				int wrongNumStartW = 0;
				for(int i = x; i < x + 8; i++) {
					for(int l = y; l < y + 8; l++) {
						if((i + l) % 2 == 0) {
							if(arr[i][l] == 'B') wrongNumStartW++;
							else wrongNumStartB++;
						}else {
							if(arr[i][l] == 'B') wrongNumStartB++;
							else wrongNumStartW++;
						}
					}
				}
				int result = Math.min(wrongNumStartW, wrongNumStartB);
				answer = Math.min(result, answer);
			}
		}
		System.out.println(answer);
	}
}