package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] cites = br.readLine().split(" ");
			int cases = buildBridge(Integer.parseInt(cites[0]), Integer.parseInt(cites[1]));
			System.out.println(cases);
		}
	}
	private static int buildBridge(int west, int east) {
		if(west < east / 2) west = east - west;
		int answer = 1;
		for(int i = 1; i <= west; i++) {
			answer = answer * east-- / i;
		}
		return answer;
	}
}