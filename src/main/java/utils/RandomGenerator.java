package utils;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomGenerator {

	/*public static List<Integer> generateRandomArray(int min, int max, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>(n);
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			list.add(random.nextInt(max + 1 - min) + min);
		}
		return list;
	}*/

	public static IntStream getStreamOfRandomIntsWithRange(int min, int max, int num) {
		Random random = new Random();
		//random.ints(num, min, max).distinct().sorted().forEach(System.out::println);
		return random.ints(num, min, max).distinct().sorted();
	}
}
