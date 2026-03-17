import java.io.*;
import java.util.*;

class Node {
	Node lt;
	Node rt;
	int data;

	Node(int data) {
		this.data = data;
	}

	public void add(int input) {

		if (input < this.data) {
			if (this.lt == null) {
				this.lt = new Node(input);
			} else {
				this.lt.add(input);
			}
		} else if (input > this.data) {
			if (this.rt == null) {
				this.rt = new Node(input);
			} else {
				this.rt.add(input);
			}
		}
	}

}

public class Main {

	static Node root;

	public void binarySearch(Node v) {
		if(v == null)
			return;
		
		binarySearch(v.lt);
		binarySearch(v.rt);
		System.out.println(v.data);
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		root = new Node(Integer.parseInt(s));

		while ((s = br.readLine()) != null && !s.isEmpty()) {
			int data = Integer.parseInt(s);
			root.add(data);
		}

		T.binarySearch(root);

	}
}
