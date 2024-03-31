package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] arr = new Person[N];
		for(int i = 0; i < N; i++) {
			String[] info = br.readLine().split(" ");
			arr[i] = new Person(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
		}
		for(int i = 0; i < arr.length; i++) {
			for(int l = i + 1; l < arr.length; l++) {
				int compare = arr[i].compareTo(arr[l]);
				if(compare == 2) arr[l].biggerThanMe++;
				else if(compare == -2) arr[i].biggerThanMe++;
			}
		}
		String answer = "";
		for(Person p : arr) {
			answer += p.biggerThanMe + 1 + " ";
		}
		answer = answer.trim();
		System.out.print(answer);
	}
}
class Person {
	private int height;
	private int weight;
	int biggerThanMe = 0;
	public Person(int weight, int height) {
		this.height = height;
		this.weight = weight;
	}
	public int compareTo(Person o) {
		int h = compareWithHeight(o);
		int w = compareWithWeight(o);
		return h + w;
	}
	private int compareWithHeight(Person o) {
		if(this.height > o.height) return 1;
		else if(this.height < o.height) return -1;
		else return 0;
	}
	private int compareWithWeight(Person o) {
		if(this.weight > o.weight) return 1;
		else if(this.weight < o.weight) return -1;
		else return 0;
	}
}