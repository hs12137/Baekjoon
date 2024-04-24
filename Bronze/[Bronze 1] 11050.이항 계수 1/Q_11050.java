package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer = calBinomialCoefficient(n+1, k);
		System.out.println(answer);
	}
	public static int calBinomialCoefficient(int n, int k) {
		if(k == 0 || k == n - 1) return 1;
		return calBinomialCoefficient(n-1, k) + calBinomialCoefficient(n-1, k-1);
	}
}