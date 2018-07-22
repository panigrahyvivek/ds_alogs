package ds_algos;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Node;

//Reference - https://algs4.cs.princeton.edu/99misc/SegmentTree.java.html 

public class SegmentTree {

	private static Logger log = LoggerFactory.getLogger(SegmentTree.class);
	
	private Node[] heap;
	private int[] array;
	private int size;
	
	public SegmentTree(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
		size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) array.length) / Math.log(2.0)) + 1)));
        heap = new Node[size];
        build(1, 0, array.length);
	}
	
	public int size() {
        return array.length;
    }
	
	private void build(int v, int from, int size) {
		heap[v] = new Node();
		heap[v].from = from;
		heap[v].to = from+size-1;
		
		if(size == 1) {
			heap[v].sum = array[from];
			heap[v].min = array[from];
		}
		else {
			build(2*v, from, size/2);
			build(2*v+1, from+size/2, size - size/2);
			
			heap[v].sum = heap[2*v].sum + heap[2*v+1].sum;
			heap[v].min = Math.min(heap[2*v].min, heap[2*v+1].min);
		}
	}
	
	public int rsq(int from,int to) {
		return rsq(1,from,to);
	}
	
	private int rsq(int v,int from, int to) {
		Node n = heap[v];
		
		if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
            return (to - from + 1) * n.pendingVal;
        }
		
		if (contains(from, to, n.from, n.to)) {
            return heap[v].sum;
        }

        if (intersects(from, to, n.from, n.to)) {
            propagate(v);
            int leftSum = rsq(2 * v, from, to);
            int rightSum = rsq(2 * v + 1, from, to);

            return leftSum + rightSum;
        }

        return 0;
	}
	
	private boolean contains(int from1, int to1, int from2, int to2) {
        return from2 >= from1 && to2 <= to1;
    }
	
	private boolean intersects(int from1, int to1, int from2, int to2) {
        return from1 <= from2 && to1 >= from2   //  (.[..)..] or (.[...]..)
                || from1 >= from2 && from1 <= to2; // [.(..]..) or [..(..)..
    }
	
	private void propagate(int v) {
        Node n = heap[v];

        if (n.pendingVal != null) {
            change(heap[2 * v], n.pendingVal);
            change(heap[2 * v + 1], n.pendingVal);
            n.pendingVal = null; //unset the pending propagation value
        }
    }
	
	//Save the temporal values that will be propagated lazily
    private void change(Node n, int value) {
        n.pendingVal = value;
        n.sum = n.size() * value;
        n.min = value;
        array[n.from] = value;

    }
	
	
	public static void main(String args[]) {
		int[] ar = new int[] {1,2,30,4,5,69,7};
		SegmentTree st = new SegmentTree(ar);
		
		int sum = st.rsq(3, 5);
		
		log.info("Sum is: " + sum);
		
	}
	
}
