package models;

public class Node {

	public int from;
	public int to;
	public int sum;
	public int min;
	public Integer pendingVal = null;
	
	public int size() {
        return to - from + 1;
    }

}
