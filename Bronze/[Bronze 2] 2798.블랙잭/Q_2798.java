package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int n = Integer.parseInt(input1[0]);
		int m = Integer.parseInt(input1[1]);
		int[] cardList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 0;
		
		for(int i = 0; i < n - 2; i++) {
			for(int l = i + 1; l < n - 1; l++) {
				for(int x = l + 1; x < n; x++) {
					int cardSum = cardList[i] + cardList[l] + cardList[x];
					if(cardSum <= m && cardSum > answer) answer = cardSum;
				}
			}
		}
		System.out.println(answer);
	}
}