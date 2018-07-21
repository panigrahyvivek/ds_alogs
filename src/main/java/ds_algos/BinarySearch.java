package ds_algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearch {
	private static Logger log = LoggerFactory.getLogger(BinarySearch.class);
	
	/*private static void findElement(int[] Arr, int key) {
		
	}*/

	public static void main(String args[]) {
		int intArr[] = {10,20,35,22,21,11};
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(10);
		ar.add(20);
		ar.add(15);
		ar.add(22);
		ar.add(35);
		
		Arrays.sort(intArr);
		Collections.sort(ar);
		
		int intKey = 22;
		
		log.info(intKey + " found at index = " + Arrays.binarySearch(intArr,intKey));
		log.info(intKey + " found at index = " + Collections.binarySearch(ar,intKey));
	}
}
