package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(countZeroAndOne(num));
		}
	}
	public static String countZeroAndOne(int num) {
		if(num == 0) return "1 0";
		else if(num == 1) return "0 1";
		int[] num1 = {1, 0};
		int[] num2 = {0, 1};
		int[] sub = {0, 0};
		for(int i = 2; i <= num; i++) {
			sub[0] = num2[0];
			sub[1] = num2[1];
			num2[0] += num1[0];
			num2[1] += num1[1];
			num1[0] = sub[0];
			num1[1] = sub[1];
		}
		String answer = "";
		answer += num2[0] + " " + num2[1];
		return answer;
	}
}