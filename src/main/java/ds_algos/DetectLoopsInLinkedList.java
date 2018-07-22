package ds_algos;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetectLoopsInLinkedList{
	
	private static Logger log = LoggerFactory.getLogger(DetectLoopsInLinkedList.class);
	
	private static class Node{
		private int value;
		private Node next;
		
		Node(int value){
			this.value = value;
			this.next = null;
		}
		
		Node(int value, Node p){
			this.value = value;
			this.next = p;
		}
		
		public int getValue(){
			return value;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node n) {
			this.next = n;
		}
		
	}
	
	
	private static Boolean detectLoop(LinkedList<Node> l){
		Node slow = l.getFirst();
		Node fast = l.getFirst();
		
		while(slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		LinkedList<Node> ll = new LinkedList<Node>();
		
		Node d = new Node(3);
		Node c = new Node(3, d);
		Node b = new Node(2, c);
		Node a = new Node(1, b);
		
		d.setNext(b);
		
		ll.add(a);
		ll.add(b);
		ll.add(c);
		
		
		log.info(""+ll.getFirst().next.next.getValue());
		
		log.info("Detect Loop: " + detectLoop(ll));
	}
	
}