package ds_algos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LargestSumContiguousSubArray {
	private static Logger log = LoggerFactory.getLogger(SegmentTree.class);
	
	public static void maxSubarraySum(Integer[] a) {
		int max_till_here = 0;
		int max_sum = 0;
		for(int i:a) {
			max_till_here = max_till_here + i;
			
			if(max_till_here < 0) {
				max_till_here = 0;
			}
			
			if(max_sum < max_till_here) {
				max_sum = max_till_here;
			}
			
		}
		
		log.info(max_till_here +  " "+ max_sum);
		
	}
	
	public static void main(String args[]) {
		log.info("Hello");
		
		Integer[] a = new Integer[] {-2, -3, 40, -1, -2, 1, 5, -3};
		maxSubarraySum(a);
	}
	
}