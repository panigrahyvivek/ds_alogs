package ds_algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import utils.RandomGenerator;

public class ThreeSum {
	private static Logger log = LoggerFactory.getLogger(ThreeSum.class);

	private static int printAll(int[] ar) {
		int len = ar.length;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					sum = ar[i] + ar[j] + ar[k];
					if (ar[i] + ar[j] + ar[k] == 0) {
						//log.info(ar[i] + "/" + ar[j] + "/" + ar[k]);
						count++;
					}
				}
			}
		}
		return count;
	}

	private static int printAllOptimized(int[] ar) {
		int len = ar.length;
		int count = 0;
		int sum = 0;
		Set<Integer> visitedElementCache = new HashSet<Integer>();
		int searchkey, binarySearchIndex;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {

				sum = ar[i] + ar[j];
				searchkey = -1 * sum;
				binarySearchIndex = Arrays.binarySearch(ar, searchkey);

				if (binarySearchIndex > -1 && ar[binarySearchIndex] > ar[j]) {

					// log.info(ar[i] + "/" + ar[j] + "/" + ar[binarySearchIndex]);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {

		StopWatch watch = new StopWatch();

		watch.start("RandomNumberGeneration");
		int[] ar = RandomGenerator.getStreamOfRandomIntsWithRange(-100, 100, 100).toArray();
		watch.stop();

		watch.start("FindingNullableTriplets");
		log.info("Finding Triplets with O(n3)");
		log.info("Total triplets: " + printAll(ar));
		watch.stop();

		watch.start("FindingNullableTripletsOptimized");
		log.info("Finding Triplets with O(n2logn)");
		Arrays.sort(ar);
		log.info("Total Triplets: " + printAllOptimized(ar));
		watch.stop();

		log.info(watch.prettyPrint());

	}

}
