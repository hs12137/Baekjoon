package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(getNum(k, n));
		}
	}
	public static int getNum(int k, int n) {
		if(k == 0) return n;
		if(n == 1) return 1;
		return getNum(k-1, n) + getNum(k, n-1);
	}
}