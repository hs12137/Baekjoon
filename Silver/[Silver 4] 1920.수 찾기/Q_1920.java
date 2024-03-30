package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int M = Integer.parseInt(br.readLine());
		int[] arrM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arrN);
		int[] result = new int[M];
		for(int i = 0; i < M; i++) {
			result[i] = search(arrN, N-1, arrM[i]);
		}
		for(int m : result) System.out.println(m);
	}
	private static int search(int[] array, int max, int num) {
		int min = 0;
		int search;
		while(min <= max) {
			search = (max + min) / 2;
			int sNum = array[search];
			if(sNum > num) max = search - 1;
			else if(sNum < num) min = search + 1;
			else return 1;
		}
		return 0;
	}
}