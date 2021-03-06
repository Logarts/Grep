import java.io.*;

public class Data {
	private String data = "";
	private String path;
	private int count = 0;
	private DArray array = new DArray();
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
				array.add(cut);
				temp = temp.substring(index+2);
				i++;
			}
		}
	}
	
	public void parse(String target) {
		boolean yep = false;
		for (int i = 0; i <= count; i++) {
			String temp = array.get(i);
			target = target.toLowerCase();
			temp = temp.toLowerCase();
			boolean boo = temp.contains(target);
			if (boo) {
				System.out.println(array.get(i));
				yep = true;
			}
		}
		if (!yep) {
			System.out.println("Can't find, I'm sorry =(");
		}
	}
	public void print() {
		int capacity = array.capacity();
		for (int i = 0; i < capacity; i++) {
			System.out.println(i + ": " + array.get(i));
		}
	}
	
}

