
public class DArray {
	private String array[];
	private int capacity = 0;
	DArray(String element) {
		add(element);
	}
	DArray() {
		
	}
	
	public void add(String element) {
		if (capacity == 0) {
			array = new String[++capacity];
			array[capacity - 1] = element;
		} else {
			String temp[] = new String[++capacity];
			for (int i = 0; i < capacity - 1; i++) {
				temp[i] = array[i];
			}
			temp[capacity - 1] = element;
			array = null;
			array = new String[capacity];
			for (int i = 0; i < capacity; i++) {
				array[i] = temp[i];
			}
			temp = null;
		}
	}
	
	public String get(int index) {
		return array[index];
	}
	
	public int capacity() {
		return capacity;
	}
}
