package ds_algos;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import utils.RandomGenerator;


public class ThreeSum {
	private static Logger log = LoggerFactory.getLogger(ThreeSum.class);
	
	private static void printAll (List<Integer> ar ) {
		int len = ar.size();
		for(int i=0; i<len ; i++){
			for(int j=i+1; j<len; j++) {
				for(int k=j+1; k<len; k++) {
					int sum = ar.get(i)+ar.get(j)+ar.get(k);
					if(ar.get(i)+ar.get(j)+ar.get(k) == 0) {
						log.info(ar.get(i) +"/"+ ar.get(j) + "/" + ar.get(k));
					}
				} 
			}
		}
	}

	public static void main(String args[]) {
		System.out.println("Hello world!!");
		
		List<Integer> ar= RandomGenerator.getStreamOfRandomIntsWithRange(-10,10,15).boxed().collect(Collectors.toList());
		log.info(ar.toString());
		StopWatch watch = new StopWatch();
		watch.start();
		printAll(ar);
		watch.stop();
		log.info("Complete");
		
		
	}

	
}
