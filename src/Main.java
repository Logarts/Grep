import java.io.*;
import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data("text.txt");
		try {
			data.input();
		} catch(IOException e) {
			System.out.println("Fuck!");
		}
		System.out.println("Type target word here...");
		Scanner scan = new Scanner(System.in);
		String target = scan.next();
		scan.close();
		System.out.println(target);
		data.parse(target);
	}

}
