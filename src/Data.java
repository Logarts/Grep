import java.io.*;
import java.util.Vector;


public class Data {
	private String data = "";
	private String path;
	private int count = 0;
	private Vector<String> array = new Vector<String>();
	Data(String p) {
		path = p;
	}
	public void input() throws FileNotFoundException {
		FileInputStream fileIn;
		int in = 0;
		
		try {
			fileIn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		try {
			do {
				in = fileIn.read();
				if (in != -1) {
					data += ((char) in);
				}
				if (in == 13) {
					count++;
				}
			} while (in != -1);
		} catch (IOException e) {
			System.out.println("IO error");
		} finally {
			try {
				fileIn.close();
			} catch (IOException e) {
				System.out.println("Closing error");
			}
		}
		toArray();
	}
	private void toArray() {
		String temp = data;
		String cut = "";
		int index = 0;
		int i = 0;
		while (i <= count) {
			index = temp.indexOf(13);
			if (index == -1) {
				array.add(temp);
				break;
			} else {
				cut = temp.substring(0, (index));
				System.out.println(i + ": " + cut);
				array.add(cut);
				temp = temp.substring(index+2);
				i++;
			}
		}
	}
	public void parse(String target) {
		for (int i = 0; i <= count; i++) {
			String temp = array.get(i);
			int boo = temp.compareToIgnoreCase(target);
			if (boo > 0) {
				System.out.println(temp);
			}
		}
	}
}
