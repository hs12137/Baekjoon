package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int gcd = num1 > num2 ? getGCD(num1, num2) : getGCD(num2, num1);
		int lcm = num1 * num2 / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}
	public static int getGCD(int num1, int num2) {
		if(num1 % num2 == 0) return num2;
		return getGCD(num2, num1 % num2);
	}
}