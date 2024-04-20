package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1037 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max = 0;
		int min = 1000000;
		for(int num : numArr) {
			if(max < num) max = num;
			if(min > num) min = num;
		}
		int answer = max * min;
		System.out.println(answer);
	}

}
