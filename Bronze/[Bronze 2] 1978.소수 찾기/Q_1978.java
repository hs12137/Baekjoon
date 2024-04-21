package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 0;
		for(int num : numArr) {
			if(isDecimal(num)) answer++;
		}
		System.out.println(answer);
	}
	public static boolean isDecimal(int num) {
		if(num == 1) return false;
		for(int i = 2; i * i <=num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}