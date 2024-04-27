package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q_10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Node[] arr = new Node[n];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			arr[i] = new Node(Integer.parseInt(input[0]), input[1]);
		}
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.age - o2.age;
			}
		});
		for(Node node : arr) {
			sb.append("\n").append(node.age).append(" ").append(node.name);
		}
		System.out.println(sb.substring(1));
	}
}
class Node{
	int age;
	String name;
	Node(int age, String name) {
		this.age = age;
		this.name = name;
	}
}