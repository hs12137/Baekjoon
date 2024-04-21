package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = br.readLine();
			if(input.equals("0 0 0")) break;
			int[] numArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			if(numArr[0] > numArr[2]) {
				int temp = numArr[0];
				numArr[0] = numArr[2];
				numArr[2] = temp;
			}
			if(numArr[1] > numArr[2]) {
				int temp = numArr[1];
				numArr[1] = numArr[2];
				numArr[2] = temp;
			}
			String answer = ((numArr[0] * numArr[0]) + (numArr[1] * numArr[1])) == (numArr[2] * numArr[2]) ? "right" : "wrong";
			System.out.println(answer);
		}
	}
}