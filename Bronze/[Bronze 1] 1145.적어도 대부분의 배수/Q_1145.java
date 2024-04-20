package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1145 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 1000000;
		for(int i = 0; i < 3; i++) {
			for(int l = i + 1; l < 4; l++) {
				for(int x = l + 1; x < 5; x++){
					int lcm = getLCM(getLCM(numArr[i], numArr[l]), numArr[x]);
					if(answer > lcm) answer = lcm;
				}
			}
		}
		System.out.println(answer);
	}
	public static int getGCD(int num1, int num2) {
		if(num1 % num2 == 0) return num2;
		return getGCD(num2, num1 % num2);
	}
	public static int getLCM(int num1, int num2) {
		return num1 * num2 / getGCD(num1, num2);
	}
}